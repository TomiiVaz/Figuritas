package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.excepciones.*;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class ControladorFigurita {

    private final ServicioFigurita servicioFigu;
    private final ServicioSeleccion servicioSelec;
    private final ServicioAlbum servicioAlbum;

    private final ServicioUsuario servicioLogin;
    private final ServicioRegistroPegada servicioRegistroPegada;

    private final ServicioComentario servicioComent;

    @Autowired
    public ControladorFigurita(ServicioFigurita servicioFigu, ServicioSeleccion servicioSelec, ServicioAlbum servicioAlbum, ServicioUsuario servicioLogin, ServicioRegistroPegada servicioRegistroPegada, ServicioComentario servicioComent) {

        this.servicioFigu = servicioFigu;
        this.servicioSelec = servicioSelec;
        this.servicioAlbum = servicioAlbum;
        this.servicioLogin = servicioLogin;
        this.servicioRegistroPegada = servicioRegistroPegada;
        this.servicioComent = servicioComent;
    }

    @RequestMapping(path = "/configuracion/figurita/", method = RequestMethod.GET)
    public ModelAndView verVistaFiguritaConfig(HttpServletRequest request) {
        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();
        List<Posicion> posiciones = this.servicioFigu.traerPosiciones();
        List<Rareza> rarezas = this.servicioFigu.traerRarezas();
        List<Album> albunes = this.servicioAlbum.traerAlbunes();
        List<Figurita> figuritas = this.servicioFigu.traerFiguritas();
        String rol = (String) request.getSession().getAttribute("ROL");
        Long id = (Long) request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario) request.getSession().getAttribute("USUARIO");

        ModelMap model = new ModelMap();
        model.put("usuario", userLogueado);
        model.put("id", id);
        model.put("rol", rol);
        model.put("selecciones", selecciones);
        model.put("rarezas", rarezas);
        model.put("posiciones", posiciones);
        model.put("albunes", albunes);
        model.put("figuritas", figuritas);

        return new ModelAndView("configFigurita", model);
    }

    @RequestMapping(path = "/configuracion/figurita/agregar", method = RequestMethod.POST)
    public ModelAndView crearFigurita(@ModelAttribute("figurita") Figurita figurita, HttpServletRequest request) {


        try {
            this.servicioFigu.agregarFigurita(figurita);
        } catch (FiguritaConNombreRepetidoException e) {
            return figuritaFallida(figurita, "NombreFiguritaRepetido", "El nombre de la figurita ya existe", request);

        } catch (FiguritaConNombreNullOVacioException e) {
            return figuritaFallida(figurita, "NombreFiguritaNullVacio", "Debe agregar un nombre, dato obligatorio", request);

        } catch (FiguritaConSeleccionVaciaExcepition e) {
            return figuritaFallida(figurita, "SeleccionFiguritaVacia", "Debe seleccionar una seleccion, dato obligatorio", request);

        } catch (FiguritaConPosicionVaciaExcepition e) {
            return figuritaFallida(figurita, "PosicionFiguritaVacia", "Debe seleccionar una posicion, dato obligatorio", request);

        } catch (FiguritaConRarezaVaciaExcepition e) {
            return figuritaFallida(figurita, "RarezaFiguritaVacia", "Debe seleccionar una rareza, dato obligatorio", request);

        } catch (FiguritaConAlbumVacioExcepition e) {
            return figuritaFallida(figurita, "AlbumFiguritaVacio", "Debe seleccionar un album, dato obligatorio", request);

        } catch (FiguritaConDorsalNoValidoExcepition e) {
            return figuritaFallida(figurita, "DorsalFiguritaVacio", "Debe agregar un dorsal corecto mayor a 0 y menor igual a 99", request);

        } catch (FiguritaConConEquipoVacioExcepition e) {
            return figuritaFallida(figurita, "EquipoFiguritaVacio", "Debe agregar un equipo, dato obligatorio", request);

        }

        return new ModelAndView("redirect:/configuracion-figurita");

    }

    @RequestMapping(path = "/configuracion/figurita/editar", method = RequestMethod.POST)
    public ModelAndView editarFigurita(@RequestParam("figuritaId") Long figuritaId, HttpServletRequest request) {


        Figurita figuritaEncontrada = this.servicioFigu.buscarFigurita(figuritaId);
        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();
        List<Posicion> posiciones = this.servicioFigu.traerPosiciones();
        List<Rareza> rarezas = this.servicioFigu.traerRarezas();
        List<Album> albunes = this.servicioAlbum.traerAlbunes();
        List<Figurita> figuritas = this.servicioFigu.traerFiguritas();
        String rol = (String) request.getSession().getAttribute("ROL");
        Long id = (Long) request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario) request.getSession().getAttribute("USUARIO");

        ModelMap model = new ModelMap();

        model.put("usuario", userLogueado);
        model.put("id", id);
        model.put("rol", rol);
        model.put("figuritaEncontrada", figuritaEncontrada);
        model.put("selecciones", selecciones);
        model.put("rarezas", rarezas);
        model.put("posiciones", posiciones);
        model.put("albunes", albunes);
        model.put("figuritas", figuritas);

        if (figuritaId == 0) {

            model.put("ErrorFigurita", "Ups! Se produjo un error. Chequear los datos ingresados");
            model.put("ErrorFiguritaSinSeleccionar", "Debe seleccionar una figurita, dato obligatorio");
            return new ModelAndView("configFigurita", model);
        }

        return new ModelAndView("editarFigurita", model);
    }

    @RequestMapping(path = "/configuracion/figurita/eliminar", method = RequestMethod.POST, params = {"figuritaId"})
    public ModelAndView delFigurita(@RequestParam Long figuritaId, HttpServletRequest request) {

        try {
            this.servicioFigu.eliminarFigurita(figuritaId);
        } catch (FiguritaExceptionGeneral e) {

            Figurita figurita = this.servicioFigu.buscarFigurita(figuritaId);
            List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();
            List<Posicion> posiciones = this.servicioFigu.traerPosiciones();
            List<Rareza> rarezas = this.servicioFigu.traerRarezas();
            List<Album> albunes = this.servicioAlbum.traerAlbunes();
            List<Figurita> figuritas = this.servicioFigu.traerFiguritas();
            String rol = (String) request.getSession().getAttribute("ROL");
            Long id = (Long) request.getSession().getAttribute("ID");
            Usuario userLogueado = (Usuario) request.getSession().getAttribute("USUARIO");


            ModelMap model = new ModelMap();
            model.put("figurita", figurita);
            model.put("selecciones", selecciones);
            model.put("rarezas", rarezas);
            model.put("posiciones", posiciones);
            model.put("albunes", albunes);
            model.put("figuritas", figuritas);
            model.put("usuario", userLogueado);
            model.put("id", id);
            model.put("rol", rol);
            model.put("ErrorFiguritaAElminarSinSeleccionar", "Debe seleccionar una figurita a eliminar, dato obligatorio");
            model.put("ErrorNoSeleecionoUnaFiguritaAEliminar", "Ups! Se produjo un error. Chequear los datos ingresados");
            return new ModelAndView("configFigurita", model);
        }

        return new ModelAndView("redirect:/configuracion-figurita");
    }

    // Quien usa este metodo?
    @RequestMapping(path = "/updateFalso-figurita", method = RequestMethod.POST)
    public ModelAndView crearFigurita(@ModelAttribute("figurita") Figurita figurita, @RequestParam Long id) {

        this.servicioFigu.eliminarFigurita(id);
        this.servicioFigu.agregarFigurita(figurita);

        return new ModelAndView("redirect:/configuracion-figurita");
    }

    // Quien usa este metodo?
    @RequestMapping(path = "/ver-figurita", method = RequestMethod.POST, params = {"figuritaId", "figuritaNueva"})
    public ModelAndView verFigurita(@RequestParam int figuritaId,
                                    @ModelAttribute Figurita figurita) {
        figurita.setId((long) figuritaId);
        this.servicioFigu.agregarFigurita(figurita);

        return new ModelAndView("redirect:/configuracion-figurita");
    }

    // Quien usa este metodo?
    @RequestMapping(path = "/carta", method = RequestMethod.POST)
    public ModelAndView verCarta(@RequestParam int id, HttpServletRequest request) {

        Figurita figurita = this.servicioFigu.buscarFigurita((long) id);
        String rol = (String) request.getSession().getAttribute("ROL");
        Long idLogueado = (Long) request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario) request.getSession().getAttribute("USUARIO");
        List<Comentario> comentariosFiltrados = this.servicioComent.traerComentariosPorID(figurita.getId());

        ModelMap model = new ModelMap();
        model.put("figurita", figurita);
        model.put("id", idLogueado);
        model.put("rol", rol);
        model.put("usuario", userLogueado);
        model.put("comentariosFiltrados", comentariosFiltrados);

        return new ModelAndView("figurita", model);
    }


    /*
        @RequestMapping(path = "/buscarfiguritas", method = RequestMethod.GET, params = {"busq"})
        public ModelAndView buscarFiguritas(@RequestParam String busq) {

            ModelMap resBusqueda = new ModelMap();

            List<Figurita> figs = servicioFigu.buscarFiguritaPorNombre(busq);
            resBusqueda.put("figEncontradas", figs);

            return new ModelAndView("buscarFiguritas", resBusqueda);
        }*/

    @RequestMapping(path = "/buscarfiguritas", method = RequestMethod.GET, params = {"busq"})
    public ModelAndView buscarFiguritas(@RequestParam(value = "busq") String busq,
                                        @RequestParam(value = "selSeleccion", required = false) Long sel,
                                        @RequestParam(value = "selPosicionJugador", required = false) Long pos,
                                        HttpServletRequest request) {

        ModelMap model = new ModelMap();

        List<Seleccion> selecciones = servicioSelec.traerSelecciones();
        List<Posicion> posiciones = servicioFigu.traerPosiciones();

        String rol = (String) request.getSession().getAttribute("ROL");
        Long id = (Long) request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario) request.getSession().getAttribute("USUARIO");
        List<RegistroPegada> registrosEncontrados = new ArrayList<>();
        String mensajeError = "";
        try{
            registrosEncontrados = servicioRegistroPegada.getIntercambiablesPorFiltros(busq, sel, pos, id);
        }catch (NoSeEncontraronFiguritasException e){
            mensajeError = "No se encontraron figuritas que coincidan con lo introducido";
        }

        model.put("usuario", userLogueado);
        model.put("id", id);
        model.put("rol", rol);
        model.put("todasSelecciones", selecciones);
        model.put("todasPosiciones", posiciones);
        model.put("regsEncontrados", registrosEncontrados);
        model.put("mensajeError", mensajeError);


        return new ModelAndView("buscarFiguritas", model);
    }

    @RequestMapping(path = "/sorteo", method = RequestMethod.GET)
    public ModelAndView verCarta(HttpServletRequest request) {

        String rol = (String) request.getSession().getAttribute("ROL");
        Long id = (Long) request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario) request.getSession().getAttribute("USUARIO");


        List<Figurita> figuritas = this.servicioFigu.traerFiguritas();
        int indiceAleatorio = numeroAleatorioEnRango(0, figuritas.size() - 1);
        int indiceAleatorio2 = numeroAleatorioEnRango(0, figuritas.size() - 1);
        int indiceAleatorio3 = numeroAleatorioEnRango(0, figuritas.size() - 1);

        Figurita figurita1 = figuritas.get(indiceAleatorio);
        Figurita figurita2 = figuritas.get(indiceAleatorio2);
        Figurita figurita3 = figuritas.get(indiceAleatorio3);

        ModelMap model = new ModelMap();
        model.put("id", id);
        model.put("rol", rol);
        model.put("usuario", userLogueado);
        model.put("figurita1", figurita1);
        model.put("figurita2", figurita2);
        model.put("figurita3", figurita3);

        return new ModelAndView("sorteo", model);
    }

    // Quien usa este metodo?
    @RequestMapping(path = "/asignar-ganador", method = RequestMethod.POST)
    public ModelAndView AsignarFiguritaAlGanador(@RequestParam Long id, @RequestParam Long album, HttpServletRequest request) {

        Usuario usuarioPegar = (Usuario) request.getSession().getAttribute("USUARIO");
        Figurita figuritaPegar = servicioFigu.buscarFigurita(id);
        Album albumPegar = servicioAlbum.getAlbum(album);
        RegistroPegada rp = new RegistroPegada();

        rp.setFigurita(figuritaPegar);
        rp.setAlbum(albumPegar);
        rp.setUsuario(usuarioPegar);
        rp.setIntercambiable(false);

        this.servicioRegistroPegada.pegarRegistro(rp);

        return new ModelAndView("redirect:/perfil");
    }

    private int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    private ModelAndView figuritaFallida(Figurita figurita, String errorNombre, String errorMensaje, HttpServletRequest request) {
        ModelMap model = new ModelMap();

        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();
        List<Posicion> posiciones = this.servicioFigu.traerPosiciones();
        List<Rareza> rarezas = this.servicioFigu.traerRarezas();
        List<Album> albunes = this.servicioAlbum.traerAlbunes();
        List<Figurita> figuritas = this.servicioFigu.traerFiguritas();
        String rol = (String) request.getSession().getAttribute("ROL");
        Long id = (Long) request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario) request.getSession().getAttribute("USUARIO");

        model.put(errorNombre, errorMensaje);
        model.put("figurita", figurita);
        model.put("selecciones", selecciones);
        model.put("rarezas", rarezas);
        model.put("posiciones", posiciones);
        model.put("albunes", albunes);
        model.put("figuritas", figuritas);
        model.put("usuario", userLogueado);
        model.put("id", id);
        model.put("rol", rol);
        model.put("ErrorFigurita", "Ups! Se produjo un error. Chequear los datos ingresados");

        return new ModelAndView("configFigurita", model);
    }

    //Metodos a revisar

    /*@RequestMapping(path = "/ver-figurita", method = RequestMethod.GET)
    public ModelAndView crear() {

        //servicioFigu.agregarFigurita(54);

        return new ModelAndView("figurita");
    }

    @RequestMapping(path = "/agregar-figurita", method = RequestMethod.POST)
    public ModelAndView agregarFigurita(@ModelAttribute("figurita") Figurita figurita) {

        servicioFigu.agregarFigurita(figurita);

        return new ModelAndView("redirect:/home");
    }

    //metodo listo para usar
    @RequestMapping(path = "/buscar-figurita", method = RequestMethod.POST)
    public ModelAndView buscar() {

        //servicioFigu.buscarFiguritaPorNombre("messi");

        return new ModelAndView("home");
    }

    @RequestMapping(path = "/buscar-figuritas-nombre-equipo", method = RequestMethod.POST)
    public ModelAndView buscarNombreEquipo() {

        //servicioFigu.buscarFiguritaNombreEquipo("messi","scaloneta");

        return new ModelAndView("home");
    }

    @RequestMapping(path = "/buscar-figuritas-equipo", method = RequestMethod.POST)
    public ModelAndView buscarEquipo() {

        //servicioFigu.buscarFiguritasPorEquipo(5);

        return new ModelAndView("home");
    }*/


}
