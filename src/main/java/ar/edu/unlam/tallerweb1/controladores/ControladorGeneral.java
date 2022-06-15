package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroPegada;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorGeneral {

    private final ServicioSeleccion servicioSelec;
    private final ServicioAlbum servicioAlbum;

    private final ServicioRegistroPegada servicioPegada;

    @Autowired
    public ControladorGeneral(ServicioSeleccion servicioSelec, ServicioAlbum servicioAlbum, ServicioRegistroPegada servicioPegada) {
        this.servicioSelec = servicioSelec;
        this.servicioAlbum = servicioAlbum;
        this.servicioPegada = servicioPegada;
    }

    @RequestMapping(path = "/configuracion", method = RequestMethod.GET)
    public ModelAndView mostrarConfiguracion(HttpServletRequest request) {
        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();
        String rol = (String)request.getSession().getAttribute("ROL");
        Long id = (Long)request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario)request.getSession().getAttribute("USUARIO");
        ModelMap model = new ModelMap();

        model.put("usuario", userLogueado);
        model.put("id",id);
        model.put("rol",rol);
        model.put("selecciones", selecciones);
        model.put("figurita", new Figurita());
        return new ModelAndView("configuracion", model);
    }

    @RequestMapping(path = "/configuracion-usuario", method = RequestMethod.GET)
    public ModelAndView verVistaUsuarioConfig(HttpServletRequest request) {

        String rol = (String)request.getSession().getAttribute("ROL");
        Long id = (Long)request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario)request.getSession().getAttribute("USUARIO");
        ModelMap model = new ModelMap();
        model.put("usuario", userLogueado);
        model.put("id",id);
        model.put("rol",rol);

        return new ModelAndView("configUsuario", model);
    }

    @RequestMapping(path = "/perfil", method = RequestMethod.GET)
    public ModelAndView perfil(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        List<Album> albunes = servicioAlbum.traerAlbunes();
        List<Seleccion> selecciones = servicioSelec.traerSelecciones();

        String rol = (String)request.getSession().getAttribute("ROL");
        Long id = (Long)request.getSession().getAttribute("ID");
        List<RegistroPegada> pegadas = servicioPegada.getPegadasUsuario(id);
        Usuario usuarioLogueado = (Usuario)request.getSession().getAttribute("USUARIO");
        model.put("pegadas", pegadas);
        model.put("id",id);
        model.put("rol",rol);
        model.put("usuario",usuarioLogueado);
        model.put("selecciones", selecciones);
        model.put("albunes", albunes);

        return new ModelAndView("perfil", model);
    }

    @RequestMapping(path = "/nosotros", method = RequestMethod.GET)
    public ModelAndView nosotros(HttpServletRequest request) {

        String rol = (String)request.getSession().getAttribute("ROL");
        Long id = (Long)request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario)request.getSession().getAttribute("USUARIO");
        ModelMap model = new ModelMap();

        model.put("usuario", userLogueado);
        model.put("id",id);
        model.put("rol",rol);

        return new ModelAndView("nosotros", model);
    }
}
