package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioFigurita;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorFigurita {

    private ServicioFigurita servicioFigu;
    private ServicioSeleccion servicioSelec;

    @Autowired
    public ControladorFigurita(ServicioFigurita servicioFigu, ServicioSeleccion servicioSelec) {

        this.servicioFigu = servicioFigu;
        this.servicioSelec = servicioSelec;
    }

    @RequestMapping(path = "/ver-figurita", method = RequestMethod.GET)
    public ModelAndView crear() {

        //servicioFigu.agregarFigurita(54);

        return new ModelAndView("figurita");
    }

    @RequestMapping(path = "/agregar-figurita", method = RequestMethod.POST)
    public ModelAndView agregarFigurita(@ModelAttribute("figurita") Figurita figurita)
    {

        servicioFigu.agregarFigurita(figurita);

        return new ModelAndView("redirect:/home");
    }

    //metodo listo para usar
    @RequestMapping(path = "/buscar-figurita", method = RequestMethod.POST)
    public ModelAndView buscar() {

        //servicioFigu.buscarFiguritaPorNombre("messi");

        return new ModelAndView("home");
    }

    @RequestMapping(path = "/buscar-figuritas-nombre-equipo", method = RequestMethod.POST)
    public ModelAndView buscarNombreEquipo() {

        //servicioFigu.buscarFiguritaNombreEquipo("messi","scaloneta");

        return new ModelAndView("home");
    }

    @RequestMapping(path = "/buscar-figuritas-equipo", method = RequestMethod.POST)
    public ModelAndView buscarEquipo() {

        //servicioFigu.buscarFiguritasPorEquipo(5);

        return new ModelAndView("home");
    }

    @RequestMapping(path = "/configuracion-figurita", method = RequestMethod.GET)
    public ModelAndView verVistaFiguritaConfig() {
        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();

        ModelMap model = new ModelMap();
        model.put("selecciones", selecciones);

        return new ModelAndView("configFigurita", model);
    }

}
