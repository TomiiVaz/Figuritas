package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.excepciones.CodigoIncorrectoExcepcion;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    public ControladorTransacciones(ServicioFigurita servicioFigu, ServicioSeleccion servicioSelec, ServicioAlbum servicioAlbum, ServicioUsuario servicioLogin, ServicioRegistroPegada servicioRegistroPegada, ServicioComentario servicioComent) {

        this.servicioFigu = servicioFigu;
        this.servicioSelec = servicioSelec;
        this.servicioAlbum = servicioAlbum;
        this.servicioLogin = servicioLogin;
        this.servicioRegistroPegada = servicioRegistroPegada;
        this.servicioComent = servicioComent;
    }

    @RequestMapping(path = "/publicar/{pegada.id}", method = RequestMethod.GET)
    public ModelAndView publicarFigu(@PathVariable(value = "pegada.id") Long idRegistro){
        RegistroPegada rp = servicioRegistroPegada.buscarRegistroId(idRegistro);
        rp.setIntercambiable(true);
        servicioRegistroPegada.pegarRegistro(rp);
        return new ModelAndView("redirect:/perfil");
    }

    @RequestMapping(path = "/sacar/{pegada.id}", method = RequestMethod.GET)
    public ModelAndView sacarFigu(@PathVariable(value = "pegada.id") Long idRegistro){
        RegistroPegada rp = servicioRegistroPegada.buscarRegistroId(idRegistro);
        rp.setIntercambiable(false);
        servicioRegistroPegada.pegarRegistro(rp);
        return new ModelAndView("redirect:/perfil");
    }

    @RequestMapping(path = "/pegar", method = RequestMethod.POST)
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
            return new ModelAndView("redirect:/perfil");
        } catch (CodigoIncorrectoExcepcion e ){
            return codigoIncorrecto("errorCodigo" ,"El codigo ingresado es incorrecto", request);
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

    @RequestMapping(path="filtrar-figuritas", method = RequestMethod.GET)
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
}
