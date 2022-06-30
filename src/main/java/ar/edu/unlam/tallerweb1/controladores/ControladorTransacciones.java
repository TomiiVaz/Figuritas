package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.excepciones.CodigoIncorrectoExcepcion;
import ar.edu.unlam.tallerweb1.excepciones.FiguritaAlbumSinCoincidenciaException;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorTransacciones {

    private final ServicioFigurita servicioFigu;
    private final ServicioSeleccion servicioSelec;
    private final ServicioAlbum servicioAlbum;

    private final ServicioUsuario servicioLogin;
    private final ServicioRegistroPegada servicioRegistroPegada;

    private final ServicioComentario servicioComent;

    private final ServicioRegistroIntercambio servicioRegistroIntercambio;

    @Autowired
    public ControladorTransacciones(ServicioFigurita servicioFigu, ServicioSeleccion servicioSelec, ServicioAlbum servicioAlbum, ServicioUsuario servicioLogin, ServicioRegistroPegada servicioRegistroPegada, ServicioComentario servicioComent, ServicioRegistroIntercambio servicioRegistroIntercambio) {

        this.servicioFigu = servicioFigu;
        this.servicioSelec = servicioSelec;
        this.servicioAlbum = servicioAlbum;
        this.servicioLogin = servicioLogin;
        this.servicioRegistroPegada = servicioRegistroPegada;
        this.servicioComent = servicioComent;
        this.servicioRegistroIntercambio = servicioRegistroIntercambio;
    }

    @RequestMapping(path = "/perfil/publicar/{pegada.id}", method = RequestMethod.GET)
    public ModelAndView publicarFigu(@PathVariable(value = "pegada.id") Long idRegistro){
        RegistroPegada rp = servicioRegistroPegada.buscarRegistroId(idRegistro);
        rp.setIntercambiable(true);
        servicioRegistroPegada.pegarRegistro(rp);
        return new ModelAndView("redirect:/perfil/");
    }

    @RequestMapping(path = "/perfil/sacar/{pegada.id}", method = RequestMethod.GET)
    public ModelAndView sacarFigu(@PathVariable(value = "pegada.id") Long idRegistro){
        RegistroPegada rp = servicioRegistroPegada.buscarRegistroId(idRegistro);
        rp.setIntercambiable(false);
        servicioRegistroPegada.pegarRegistro(rp);
        return new ModelAndView("redirect:/perfil/");
    }

    @RequestMapping(path = "/perfil/pegar", method = RequestMethod.POST)
    public ModelAndView pegarFigu(@RequestParam Long albumIdd, @RequestParam Long id, HttpServletRequest request) {
        // buscar album, buscar figurita, agarrar usuario
        Usuario usuarioPegar = (Usuario) request.getSession().getAttribute("USUARIO");
        Figurita figuritaPegar = servicioFigu.buscarFigurita(id);
        Album albumPegar = servicioAlbum.getAlbum(albumIdd);
        RegistroPegada rp = new RegistroPegada();

        rp.setFigurita(figuritaPegar);
        rp.setAlbum(albumPegar);
        rp.setUsuario(usuarioPegar);
        rp.setIntercambiable(false);
        try{
            servicioRegistroPegada.pegarRegistro(rp);
            return new ModelAndView("redirect:/perfil/");
        } catch (CodigoIncorrectoExcepcion e ){
            return codigoIncorrecto("errorCodigo" ,"El codigo ingresado es incorrecto", request);
        } catch (FiguritaAlbumSinCoincidenciaException e){
            return codigoIncorrecto("errorCoincidencia", "La figurita no pertenece al album", request);
        }

    }

    private ModelAndView codigoIncorrecto(String nombreError, String error, HttpServletRequest request) {
        ModelMap model = new ModelMap();
        List<Album> albunes = servicioAlbum.traerAlbunes();
        List<Seleccion> selecciones = servicioSelec.traerSelecciones();

        String rol = (String)request.getSession().getAttribute("ROL");
        Long id = (Long)request.getSession().getAttribute("ID");
        List<RegistroPegada> pegadas = servicioRegistroPegada.getPegadasUsuario(id);
        Usuario usuarioLogueado = (Usuario)request.getSession().getAttribute("USUARIO");
        model.put("pegadas", pegadas);
        model.put("id",id);
        model.put("rol",rol);
        model.put("usuario",usuarioLogueado);
        model.put("selecciones", selecciones);
        model.put("albunes", albunes);
        model.put(nombreError, error);

        return new ModelAndView("perfil", model);
    }

    @RequestMapping(path="perfil/filtrar", method = RequestMethod.GET)
    private ModelAndView filtrar(@RequestParam(value = "albumId", required = false) Long album,
                                 @RequestParam(value="seleccionId", required=false) Long seleccion,
                                 HttpServletRequest request){
        ModelMap model=getModel(request);
        List<RegistroPegada> busqueda =  servicioRegistroPegada.getIntercambiablesPerfil(seleccion, album, (Long) model.get("id"));
        model.put("pegadas", busqueda);
        return new ModelAndView("perfil", model);
    }

    private ModelMap getModel(HttpServletRequest request){
        ModelMap model = new ModelMap();
        List<Album> albunes = servicioAlbum.traerAlbunes();
        List<Seleccion> selecciones = servicioSelec.traerSelecciones();
        String rol = (String)request.getSession().getAttribute("ROL");
        Long id = (Long)request.getSession().getAttribute("ID");
        Usuario usuarioLogueado = (Usuario)request.getSession().getAttribute("USUARIO");

        model.put("id",id);
        model.put("rol",rol);
        model.put("usuario",usuarioLogueado);
        model.put("selecciones", selecciones);
        model.put("albunes", albunes);
        return model;
    }

    @RequestMapping(path = "/intercambio/{intercambiable.id}", method = RequestMethod.GET)
    public ModelAndView solicitarFigu(@PathVariable(value = "intercambiable.id") Long idSolicitado, HttpServletRequest request){
        ModelMap model = new ModelMap();

        Usuario usuarioLogueado = (Usuario)request.getSession().getAttribute("USUARIO");
        List<RegistroPegada> registrosUsuarioLog = servicioRegistroPegada.getPegadasUsuario(usuarioLogueado.getId());
        RegistroPegada rp = servicioRegistroPegada.buscarRegistroId(idSolicitado);
        model.put("id",usuarioLogueado.getId());
        model.put("rol",usuarioLogueado.getRol());
        model.put("usuario",usuarioLogueado);
        model.put("rpsolicitado", rp);
        model.put("pegadasofrecidas", registrosUsuarioLog);
        request.getSession().setAttribute("IDDECIDE",idSolicitado);
        return new ModelAndView("solicitudIntercambio", model);
    }

    @RequestMapping(path="/intercambio/solicitud", method=RequestMethod.GET)
    public ModelAndView solicitarIntercambio(@RequestParam(value = "idPide") Long idPide, HttpServletRequest request){
        //validar en servicio que los albunes de ambas figuritas sean los mismos
        //setear estado del ri en el servicio
        //sacar el request IDDECIDE cuando termina
        // idDecide es el id del registro pegada de quien le llega la solicitud
        // idPidee es el id del registro pegada de quien solicita el intercambio
        Long idDecide = (Long) request.getSession().getAttribute("IDDECIDE");
        Long idPidee = idPide;
        RegistroPegada rpPide = servicioRegistroPegada.buscarRegistroId(idPidee);
        RegistroPegada rpDecide = servicioRegistroPegada.buscarRegistroId(idDecide);
        RegistroIntercambio ri = new RegistroIntercambio();
        ri.setRegistroPide(rpPide);
        ri.setRegistroDecide(rpDecide);

        try{
            servicioRegistroIntercambio.guardarRegistro(ri);
            request.getSession().removeAttribute("IDDECIDE");
            return new ModelAndView("redirect:/home");
        } catch (FiguritaAlbumSinCoincidenciaException e){
            return falloIntercambio();
        }
    }

    private ModelAndView falloIntercambio() {
        return new ModelAndView("redirect:/configuracion/seleccion/");
    }

    @RequestMapping(path = "/perfil/aceptar/{registro.id}", method = RequestMethod.GET)
    private ModelAndView aceptar(@PathVariable("registro.id") Long idRegistro){
        //cambiar estado del registro
        //intercambiar los idUsuario de los registroPegada del registro intercambio
        servicioRegistroIntercambio.aceptarIntercambio(idRegistro);
        return new ModelAndView("redirect:/perfil/");
    }

    @RequestMapping(path = "/perfil/rechazar/{registro.id}", method = RequestMethod.GET)
    private ModelAndView rechazar(@PathVariable("registro.id") Long idRegistro){
        servicioRegistroIntercambio.rechazarIntercambio(idRegistro);
        return new ModelAndView("redirect:/perfil/");
    }


    @RequestMapping(path = "/perfil/ver/{registro.id}", method = RequestMethod.GET)
    private ModelAndView ver(@PathVariable("registro.id") Long idRegistro){
        //obtener registro intercambio
        //meter en un modelo
        ModelMap model = new ModelMap();

        RegistroIntercambio registroIntercambio = servicioRegistroIntercambio.traerRegistroIntercambioId(idRegistro);
        model.put("registroIntercambio",registroIntercambio);

        return new ModelAndView("verIntercambio", model);
    }
}