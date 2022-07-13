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

    private final ServicioSession servicioSession;

    @Autowired
    public ControladorGeneral(ServicioSeleccion servicioSelec, ServicioAlbum servicioAlbum, ServicioRegistroPegada servicioPegada, ServicioUsuario servicioUsuario, ServicioRegistroIntercambio servicioRegistroIntercambio, ServicioSession servicioSession) {
        this.servicioSelec = servicioSelec;
        this.servicioAlbum = servicioAlbum;
        this.servicioPegada = servicioPegada;
        this.servicioUsuario = servicioUsuario;
        this.servicioRegistroIntercambio = servicioRegistroIntercambio;
        this.servicioSession = servicioSession;
    }

    @RequestMapping(path = "/configuracion", method = RequestMethod.GET)
    public ModelAndView mostrarConfiguracion(HttpServletRequest request) {
        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();

        ModelMap model = new ModelMap();

        model.put("usuario", servicioSession.getUser(request));
        model.put("id", servicioSession.getId(request));
        model.put("rol", servicioSession.getRol(request));
        model.put("selecciones", selecciones);
        model.put("figurita", new Figurita());
        if (servicioSession.getRol(request)==null || !servicioSession.getRol(request).equals("ADM")) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("configuracion", model);
    }

    @RequestMapping(path = "/configuracion/usuario/", method = RequestMethod.GET)
    public ModelAndView verVistaUsuarioConfig(HttpServletRequest request) {

        List<Usuario> usuarios = servicioUsuario.getUsuarios();

        ModelMap model = new ModelMap();
        model.put("usuario", servicioSession.getUser(request));
        model.put("id", servicioSession.getId(request));
        model.put("rol", servicioSession.getRol(request));
        model.put("usuarios", usuarios);
        if (servicioSession.getRol(request)==null || !servicioSession.getRol(request).equals("ADM")) {
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
        List<RegistroPegada> pegadasSinRepetidas = servicioPegada.getPegadasUsuarioSinRepetidas(id);

        Usuario usuarioLogueado = servicioUsuario.getUsuario(id);

        int userQatar = 0;
        int userRusia = 0;
        int userBrasil = 0;


        //recorro la lista de figuritas pegadas, dependiendo del albun las guardo solamente el nombre en un set para que no me cuente las figuritas repetidas
        for (RegistroPegada item : pegadasSinRepetidas) {
            switch (item.getAlbum().getNombre()) {
                case "Mundial-Qatar-2022":
                    userQatar++;
                    break;
                case "Mundial-Rusia-2018":
                    userRusia++;
                    break;
                case "Mundial-Brasil-2014":
                    userBrasil++;
                    break;
            }
        }

        int totalFigsQatar = servicioAlbum.getCantidadDeFiguritasDeUnAlbum("Mundial-Qatar-2022");
        int totalFigsRusia = servicioAlbum.getCantidadDeFiguritasDeUnAlbum("Mundial-Rusia-2018");
        int totalFigsBrasil = servicioAlbum.getCantidadDeFiguritasDeUnAlbum("Mundial-Brasil-2014");

        int porcentajeQatar = userQatar*100 / totalFigsQatar;
        int porcentajeRusia = userRusia*100 / totalFigsRusia;
        int porcentajeBrasil = userBrasil*100 / totalFigsBrasil;



        ModelMap model = new ModelMap();
        model.put("pegadas", pegadas);
        model.put("id", id);
        model.put("rol", rol);
        model.put("usuario", usuarioLogueado);
        model.put("selecciones", selecciones);
        model.put("albunes", albunes);
        model.put("pidieron", mePidieron);
        model.put("pedi", pedi);
        model.put("qatar", porcentajeQatar);
        model.put("rusia", porcentajeRusia);
        model.put("brasil", porcentajeBrasil);



        return new ModelAndView("perfil", model);
    }

    @RequestMapping(path = "/nosotros", method = RequestMethod.GET)
    public ModelAndView nosotros(HttpServletRequest request) {

        ModelMap model = new ModelMap();

        model.put("usuario", servicioSession.getUser(request));
        model.put("id", servicioSession.getId(request));
        model.put("rol", servicioSession.getRol(request));

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
