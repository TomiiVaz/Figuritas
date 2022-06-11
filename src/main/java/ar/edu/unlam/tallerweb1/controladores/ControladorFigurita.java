package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class ControladorFigurita {

    private final ServicioFigurita servicioFigu;
    private final ServicioSeleccion servicioSelec;
    private final ServicioAlbum servicioAlbum;

    private final ServicioLogin servicioLogin;
    private final ServicioRegistroPegada servicioRegistroPegada;

    private final ServicioComentario servicioComent;

    @Autowired
    public ControladorFigurita(ServicioFigurita servicioFigu, ServicioSeleccion servicioSelec, ServicioAlbum servicioAlbum, ServicioLogin servicioLogin, ServicioRegistroPegada servicioRegistroPegada, ServicioComentario servicioComent) {

        this.servicioFigu = servicioFigu;
        this.servicioSelec = servicioSelec;
        this.servicioAlbum = servicioAlbum;
        this.servicioLogin = servicioLogin;
        this.servicioRegistroPegada = servicioRegistroPegada;
        this.servicioComent = servicioComent;
    }

    @RequestMapping(path = "/ver-figurita", method = RequestMethod.GET)
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
    }

    @RequestMapping(path = "/configuracion-figurita", method = RequestMethod.GET)
    public ModelAndView verVistaFiguritaConfig(HttpServletRequest request) {
        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();
        List<Posicion> posiciones = this.servicioFigu.traerPosiciones();
        List<Rareza> rarezas = this.servicioFigu.traerRarezas();
        List<Album> albunes = this.servicioAlbum.traerAlbunes();
        List<Figurita> figuritas = this.servicioFigu.traerFiguritas();
        String rol = (String)request.getSession().getAttribute("ROL");
        Long id = (Long)request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario)request.getSession().getAttribute("USUARIO");

        ModelMap model = new ModelMap();
        model.put("usuario", userLogueado);
        model.put("id",id);
        model.put("rol",rol);
        model.put("selecciones", selecciones);
        model.put("rarezas", rarezas);
        model.put("posiciones", posiciones);
        model.put("albunes", albunes);
        model.put("figuritas", figuritas);

        return new ModelAndView("configFigurita", model);
    }

    @RequestMapping(path = "/editar-figurita", method = RequestMethod.POST)
    public ModelAndView editarFigurita(@RequestParam("figuritaId") Long figuritaId) {

        //buscarfigurita y mandar al model map
        Figurita figuritaEncontrada = this.servicioFigu.buscarFigurita(figuritaId);
        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();
        List<Posicion> posiciones = this.servicioFigu.traerPosiciones();
        List<Rareza> rarezas = this.servicioFigu.traerRarezas();
        List<Album> albunes = this.servicioAlbum.traerAlbunes();

        ModelMap model = new ModelMap();
        model.put("figuritaEncontrada", figuritaEncontrada);
        model.put("selecciones", selecciones);
        model.put("rarezas", rarezas);
        model.put("posiciones", posiciones);
        model.put("albunes", albunes);

        return new ModelAndView("editarFigurita", model);
    }

    @RequestMapping(path = "/crear-figurita", method = RequestMethod.POST)
    public ModelAndView crearFigurita(@ModelAttribute("figurita") Figurita figurita) {

        this.servicioFigu.agregarFigurita(figurita);

        return new ModelAndView("redirect:/configuracion-figurita");
    }

    @RequestMapping(path = "/updateFalso-figurita", method = RequestMethod.POST)
    public ModelAndView crearFigurita(@ModelAttribute("figurita") Figurita figurita, @RequestParam int id) {
        this.servicioFigu.eliminarFigurita(id);
        this.servicioFigu.agregarFigurita(figurita);

        return new ModelAndView("redirect:/configuracion-figurita");
    }

    @RequestMapping(path = "/ver-figurita", method = RequestMethod.POST, params = {"figuritaId", "figuritaNueva"})
    public ModelAndView verFigurita(@RequestParam int figuritaId,
                                    @ModelAttribute Figurita figurita) {
        figurita.setId((long) figuritaId);
        this.servicioFigu.agregarFigurita(figurita);

        return new ModelAndView("redirect:/configuracion-figurita");
    }

    @RequestMapping(path = "/del-figurita", method = RequestMethod.POST, params = {"figuritaId"})
    public ModelAndView delFigurita(@RequestParam int figuritaId) {

        this.servicioFigu.eliminarFigurita(figuritaId);

        return new ModelAndView("redirect:/configuracion-figurita");
    }


    @RequestMapping(path = "/carta", method = RequestMethod.POST)
    public ModelAndView verCarta(@RequestParam int id, HttpServletRequest request) {

        Figurita figurita = this.servicioFigu.buscarFigurita((long) id);
        String rol = (String)request.getSession().getAttribute("ROL");
        Long idLogueado = (Long)request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario)request.getSession().getAttribute("USUARIO");
        List<Comentario> comentariosFiltrados= this.servicioComent.traerComentariosPorID(figurita.getId());

        ModelMap model = new ModelMap();
        model.put("figurita", figurita);
        model.put("id",idLogueado);
        model.put("rol",rol);
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
    public ModelAndView buscarFiguritas(@RequestParam (value = "busq") String busq,
                                        @RequestParam (value = "selSeleccion", required = false) Long sel,
                                        @RequestParam (value = "selPosicionJugador", required = false) Long pos,
                                        HttpServletRequest request){

        ModelMap model = new ModelMap();

        List<Seleccion> selecciones = servicioSelec.traerSelecciones();
        List<Posicion> posiciones = servicioFigu.traerPosiciones();
        List<Figurita> figs = servicioFigu.buscarFiguritaPorFiltros(busq,sel,pos);
        String rol = (String)request.getSession().getAttribute("ROL");
        Long id = (Long)request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario)request.getSession().getAttribute("USUARIO");

        model.put("usuario", userLogueado);
        model.put("id",id);
        model.put("rol",rol);
        model.put("todasSelecciones", selecciones);
        model.put("todasPosiciones", posiciones);
        model.put("figEncontradas", figs);

        return new ModelAndView("buscarFiguritas", model);
    }

    @RequestMapping(path="/pegar", method = RequestMethod.POST)
    public ModelAndView pegarFigu(@RequestParam Long albumIdd, @RequestParam Long id, HttpServletRequest request){
        // buscar album, buscar figurita, agarrar usuario
        Usuario usuarioPegar = (Usuario)request.getSession().getAttribute("USUARIO");
        Figurita figuritaPegar = servicioFigu.buscarFigurita(id);
        Album albumPegar = servicioAlbum.getAlbum(albumIdd);
        RegistroPegada rp = new RegistroPegada();

        rp.setFigurita(figuritaPegar);
        rp.setAlbum(albumPegar);
        rp.setUsuario(usuarioPegar);

        servicioRegistroPegada.pegarRegistro(rp);

        return new ModelAndView("redirect:/perfil");
    }

    @RequestMapping(path = "/sorteo-figurita", method = RequestMethod.GET)
    public ModelAndView verCarta(HttpServletRequest request) {

        String rol = (String)request.getSession().getAttribute("ROL");
        Long id = (Long)request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario)request.getSession().getAttribute("USUARIO");


        List<Figurita> figuritas = this.servicioFigu.traerFiguritas();
        int indiceAleatorio = numeroAleatorioEnRango(0, figuritas.size() - 1);
        int indiceAleatorio2 = numeroAleatorioEnRango(0, figuritas.size() - 1);
        int indiceAleatorio3 = numeroAleatorioEnRango(0, figuritas.size() - 1);

        Figurita figurita1 = figuritas.get(indiceAleatorio);
        Figurita figurita2 = figuritas.get(indiceAleatorio2);
        Figurita figurita3 = figuritas.get(indiceAleatorio3);

        ModelMap model = new ModelMap();
        model.put("id",id);
        model.put("rol",rol);
        model.put("usuario", userLogueado);
        model.put("figurita1", figurita1);
        model.put("figurita2", figurita2);
        model.put("figurita3", figurita3);

        return new ModelAndView("sorteo", model);
    }

    private int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }


    @RequestMapping(path = "/asignar-ganador", method = RequestMethod.POST)
    public ModelAndView AsignarFiguritaAlGanador(@ModelAttribute("figurita") Figurita figurita,HttpServletRequest request) {

        Long idLogueado = (Long)request.getSession().getAttribute("ID"); //esto no anda
        figurita.setId(idLogueado); // esto no anda
        this.servicioFigu.agregarFigurita(figurita);

        return new ModelAndView("redirect:/home");
    }

}
