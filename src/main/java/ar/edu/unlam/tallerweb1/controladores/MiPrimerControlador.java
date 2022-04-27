package ar.edu.unlam.tallerweb1.controladores;


import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//Para especificarle a Spring que esta es una clase controlador.
@Controller
public class MiPrimerControlador {

                            // Lo que aparece en la url
    @RequestMapping(path = "/miprimerurl", method = RequestMethod.GET)
                        // Nombre del metodo
    public ModelAndView miPrimerVista(){


        // El primer parametro es el nombre de la vista,
        return new ModelAndView("vista1");
    }

    @RequestMapping(path = "/segundavista", method = RequestMethod.GET)
    public ModelAndView mostrarVistaDos(@RequestParam(value="n")String nombre,
                                        @RequestParam(value="a")String apellido){
        // Esto es como hasmap
        ModelMap modelo = new ModelMap();

        modelo.put("nombre", nombre);
        modelo.put("apellido", apellido);
                                                // Modelo que necesitamos que vamos a llevar a la vista
        return new ModelAndView("vista2", modelo);
    }

    @RequestMapping(path = "/segundavista/operando", method = RequestMethod.GET)
    public ModelAndView mostrarVistaDos(@RequestParam(value="op1")Integer op1,
                                        @RequestParam(value="op2")Integer op2){
        ModelMap modelo = new ModelMap();

        // Es encesario esto? -> Traermelo hasta aca -> NO
//        modelo.put("op1", op1);
//        modelo.put("op2", op2);

        modelo.put("resultado", op1+op2);

        return new ModelAndView("vista2", modelo);
    }

    @RequestMapping(path = "/segundavista/categoria/{nombreCategoria}", method = RequestMethod.GET)
    public ModelAndView mostrarVistaDos(@PathVariable(value = "nombreCategoria") String nombre){
        ModelMap modelo = new ModelMap();

        modelo.put("nombre", nombre);

        return new ModelAndView("vista2", modelo);
    }

}
