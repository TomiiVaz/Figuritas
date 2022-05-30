package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Seleccion;
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

    private ServicioSeleccion servicioSelec;

    @Autowired
    public ControladorSeleccion(ServicioSeleccion servicioSelec) {
        this.servicioSelec = servicioSelec;
    }

    @RequestMapping(path = "/crear-seleccion", method = RequestMethod.GET)
    public ModelAndView verFormulario() {

        return new ModelAndView("formSeleccion");
    }

    @RequestMapping(path = "/crear-seleccion", method = RequestMethod.POST)
    public ModelAndView crearSeleccion(@ModelAttribute("selecciones") Seleccion seleccion, HttpServletRequest request) {

        this.servicioSelec.crearSeleccion(seleccion);

        return new ModelAndView("redirect:/configuracion-seleccion");
    }

    @RequestMapping(path = "/configuracion-seleccion", method = RequestMethod.GET)
    public ModelAndView verVistaSeleccionConfig() {
        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();

        ModelMap model = new ModelMap();
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
