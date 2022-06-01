package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorSeleccion {

    private final ServicioSeleccion servicioSelec;
    private final ServicioAlbum servicioAlbum;

    @Autowired
    public ControladorSeleccion(ServicioSeleccion servicioSelec, ServicioAlbum servicioAlbum) {
        this.servicioSelec = servicioSelec;
        this.servicioAlbum = servicioAlbum;
    }

    @RequestMapping(path = "/crear-seleccion", method = RequestMethod.POST)
    public ModelAndView crearSeleccion(@ModelAttribute("selecciones") Seleccion seleccion) {
        this.servicioSelec.crearSeleccion(seleccion);

        return new ModelAndView("redirect:/configuracion-seleccion");
    }

    @RequestMapping(path = "/configuracion-seleccion", method = RequestMethod.GET)
    public ModelAndView verVistaSeleccionConfig(HttpServletRequest request) {
        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();
        List<Album> albunes = this.servicioAlbum.traerAlbunes();
        String rol = (String)request.getSession().getAttribute("ROL");
        Long id = (Long)request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario)request.getSession().getAttribute("USUARIO");

        ModelMap model = new ModelMap();
        model.put("usuario", userLogueado);
        model.put("id",id);
        model.put("rol",rol);
        model.put("albunes", albunes);
        model.put("selecciones" , selecciones);

        return new ModelAndView("configSeleccion", model);
    }
    @RequestMapping(path = "/ver-selecciones" , method = RequestMethod.POST, params = {"seleccionId","nombreNuevo"})
    public ModelAndView verSelecciones(@RequestParam int seleccionId,
                                       @RequestParam String nombreNuevo){

        this.servicioSelec.editarSeleccion((long)seleccionId, nombreNuevo);

        return new ModelAndView("redirect:/configuracion-seleccion");
    }

    @RequestMapping(path = "/del-seleccion" , method = RequestMethod.POST, params = {"seleccionId"})
    public ModelAndView delSelecciones(@RequestParam int seleccionId){

        this.servicioSelec.eliminarSeleccion((long)seleccionId);

        return new ModelAndView("redirect:/configuracion-seleccion");
    }

}
