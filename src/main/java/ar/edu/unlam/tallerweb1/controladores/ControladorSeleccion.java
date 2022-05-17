package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    public ModelAndView crearSeleccion(@ModelAttribute("datosSeleccion") Seleccion seleccion, HttpServletRequest request) {

        this.servicioSelec.crearSeleccion(seleccion);
        return new ModelAndView("home");
    }

}
