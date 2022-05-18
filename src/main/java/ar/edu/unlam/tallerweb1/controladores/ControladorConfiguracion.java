package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioFigurita;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorConfiguracion {

    private ServicioFigurita servicioFigu;
    private ServicioSeleccion servicioSelec;
    private ServicioAlbum servicioAl;

    @Autowired
    public ControladorConfiguracion(ServicioFigurita servicioFigu, ServicioSeleccion servicioSelec, ServicioAlbum servicioAl) {

        this.servicioFigu = servicioFigu;
        this.servicioSelec = servicioSelec;
        this.servicioAl = servicioAl;
    }

    @RequestMapping(path = "/configuracion", method = RequestMethod.GET)
    public ModelAndView mostrarConfiguracion() {
        return new ModelAndView("configuracion");
    }


}
