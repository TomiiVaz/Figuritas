package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;

@Controller
public class ControladorGeneral {

    private final ServicioSeleccion servicioSelec;
    private final ServicioAlbum servicioAlbum;

    private final ServicioRegistroPegada servicioPegada;
    private final ServicioUsuario servicioUsuario;

    private final ServicioRegistroIntercambio servicioRegistroIntercambio;

    @Autowired
    public ControladorGeneral(ServicioSeleccion servicioSelec, ServicioAlbum servicioAlbum, ServicioRegistroPegada servicioPegada, ServicioUsuario servicioUsuario, ServicioRegistroIntercambio servicioRegistroIntercambio) {
        this.servicioSelec = servicioSelec;
        this.servicioAlbum = servicioAlbum;
        this.servicioPegada = servicioPegada;
        this.servicioUsuario = servicioUsuario;
        this.servicioRegistroIntercambio = servicioRegistroIntercambio;
    }

    @RequestMapping(path = "/configuracion", method = RequestMethod.GET)
    public ModelAndView mostrarConfiguracion(HttpServletRequest request) {
        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();

        String rol = getSessionRol(request);
        Long id = getSessionId(request);

        Usuario userLogueado = getSessionUserLog(request);
        ModelMap model = new ModelMap();

        model.put("usuario", userLogueado);
        model.put("id", id);
        model.put("rol", rol);
        model.put("selecciones", selecciones);
        model.put("figurita", new Figurita());
        if (rol==null || !rol.equals("ADM")) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("configuracion", model);
    }

    @RequestMapping(path = "/configuracion/usuario/", method = RequestMethod.GET)
    public ModelAndView verVistaUsuarioConfig(HttpServletRequest request) {

        String rol = getSessionRol(request);
        Long id = getSessionId(request);
        Usuario userLogueado = getSessionUserLog(request);

        List<Usuario> usuarios = servicioUsuario.getUsuarios();

        ModelMap model = new ModelMap();
        model.put("usuario", userLogueado);
        model.put("id", id);
        model.put("rol", rol);
        model.put("usuarios", usuarios);
        if (rol==null || !rol.equals("ADM")) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("configUsuario", model);
    }

    @RequestMapping(path = "/perfil/", method = RequestMethod.GET)
    public ModelAndView perfil(HttpServletRequest request) {

        List<Album> albunes = servicioAlbum.traerAlbunes();
        List<Seleccion> selecciones = servicioSelec.traerSelecciones();

        String rol = getSessionRol(request);
        Long id = getSessionId(request);

        List<RegistroIntercambio> mePidieron = servicioRegistroIntercambio.getIntercambiosQueMePiden(id);
        List<RegistroIntercambio> pedi = servicioRegistroIntercambio.getIntercambiosQueHago(id);
        
        List<RegistroPegada> pegadas = servicioPegada.getPegadasUsuario(id);
        Usuario usuarioLogueado = servicioUsuario.getUsuario(id);

        HashSet<String> qatar = new HashSet<String>();
        HashSet<String> rusia = new HashSet<String>();
        HashSet<String> brasil = new HashSet<String>();

        //recorro la lista de figuritas pegadas, dependiendo del albun las guardo solamente el nombre en un set para que no me cuente las figuritas repetidas
        for (RegistroPegada item : pegadas) {
            switch (item.getAlbum().getNombre()) {
                case "Mundial-Qatar-2022":
                  qatar.add(item.getFigurita().getNombre());
                    break;
                case "Mundial-Rusia-2018":
                    rusia.add(item.getFigurita().getNombre());
                    break;
                case "Mundial-Brasil-2014":
                    brasil.add(item.getFigurita().getNombre());
                    break;
            }
        }


        ModelMap model = new ModelMap();
        model.put("pegadas", pegadas);
        model.put("id", id);
        model.put("rol", rol);
        model.put("usuario", usuarioLogueado);
        model.put("selecciones", selecciones);
        model.put("albunes", albunes);
        model.put("pidieron", mePidieron);
        model.put("pedi", pedi);
        model.put("qatar", qatar.size());
        model.put("rusia", rusia.size());
        model.put("brasil", brasil.size());


        return new ModelAndView("perfil", model);
    }

    @RequestMapping(path = "/nosotros", method = RequestMethod.GET)
    public ModelAndView nosotros(HttpServletRequest request) {

        String rol = getSessionRol(request);
        Long id = getSessionId(request);
        Usuario userLogueado = getSessionUserLog(request);
        ModelMap model = new ModelMap();

        model.put("usuario", userLogueado);
        model.put("id", id);
        model.put("rol", rol);

        return new ModelAndView("nosotros", model);
    }

    public static String getSessionRol(HttpServletRequest request) {
        String rol = (String) request.getSession().getAttribute("ROL");
        return rol;
    }

    public static Long getSessionId(HttpServletRequest request) {
        Long id = (Long) request.getSession().getAttribute("ID");
        return id;
    }

    public static Usuario getSessionUserLog(HttpServletRequest request) {
        Usuario userLogueado = (Usuario) request.getSession().getAttribute("USUARIO");
        return userLogueado;
    }
}
