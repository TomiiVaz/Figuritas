package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorGeneral {

    private ServicioSeleccion servicioSelec;

    @Autowired
    public ControladorGeneral(ServicioSeleccion servicioSelec) {
        this.servicioSelec = servicioSelec;
    }

    @RequestMapping(path = "/configuracion", method = RequestMethod.GET)
    public ModelAndView mostrarConfiguracion() {
        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();


        ModelMap model = new ModelMap();
        model.put("selecciones", selecciones);
        model.put("figurita", new Figurita());
        return new ModelAndView("configuracion", model);
    }

}
