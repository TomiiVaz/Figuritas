package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorComentario {


    private final ServicioComentario servicioComent;
    private final ServicioFigurita servicioFigu;

    @Autowired
    public ControladorComentario(ServicioComentario servicioComent, ServicioFigurita servicioFigu) {
        this.servicioComent = servicioComent;
        this.servicioFigu = servicioFigu;
    }

    @RequestMapping(path = "/carta/agregar-comentario", method = RequestMethod.POST)
    public ModelAndView agregarComentario(@ModelAttribute("comentario") Comentario comentario) {

        this.servicioComent.agregarComentario(comentario);

        return new ModelAndView("redirect:/home");
    }

}
