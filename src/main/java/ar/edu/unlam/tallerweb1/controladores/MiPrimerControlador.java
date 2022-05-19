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
    public ModelAndView miPrimerVista() {


        // El primer parametro es el nombre de la vista,
        return new ModelAndView("vista1");
    }

    @RequestMapping(path = "/segundavista", method = RequestMethod.GET)
    public ModelAndView mostrarVistaDos(@RequestParam(value = "n") String nombre,
                                        @RequestParam(value = "a") String apellido) {
        // Esto es como hasmap
        ModelMap modelo = new ModelMap();

        modelo.put("nombre", nombre);
        modelo.put("apellido", apellido);
        // Modelo que necesitamos que vamos a llevar a la vista
        return new ModelAndView("vista2", modelo);
    }

    @RequestMapping(path = "/segundavista/operando", method = RequestMethod.GET)
    public ModelAndView mostrarVistaDos(@RequestParam(value = "op1") Integer op1,
                                        @RequestParam(value = "op2") Integer op2) {
        ModelMap modelo = new ModelMap();

        // Es encesario esto? -> Traermelo hasta aca -> NO
//        modelo.put("op1", op1);
//        modelo.put("op2", op2);

        modelo.put("resultado", op1 + op2);

        return new ModelAndView("vista2", modelo);
    }

    @RequestMapping(path = "/segundavista/categoria/{nombreCategoria}", method = RequestMethod.GET)
    public ModelAndView mostrarVistaDos(@PathVariable(value = "nombreCategoria") String nombre) {
        ModelMap modelo = new ModelMap();

        modelo.put("nombre", nombre);

        return new ModelAndView("vista2", modelo);
    }

    /* Nos redirecciona a la vista registrate by: Tomas */
    @RequestMapping(path = "/registrarse", method = RequestMethod.GET)
    public ModelAndView registrarse() {

        return new ModelAndView("registroUsuario");
    }

    /* Para poder visualizar el perfil, es de uso de prueba */
    @RequestMapping(path = "/perfil", method = RequestMethod.GET)
    public ModelAndView perfil() {

        return new ModelAndView("perfil");
    }


    @RequestMapping(path = "/nosotros", method = RequestMethod.GET)
    public ModelAndView nosotros() {

        return new ModelAndView("nosotros");
    }


    @RequestMapping(path = "/buscarfiguritas", method = RequestMethod.GET, params = {"busq","sel","pos"})
    public ModelAndView buscarFiguritas(@RequestParam String busq,
                                        @RequestParam String sel,
                                        @RequestParam String pos){

        ModelMap modelo = new ModelMap();

        modelo.put("busq", busq);

        return new ModelAndView("buscarFiguritas", modelo);
    }

    @RequestMapping(path = "/buscarfiguritas", method = RequestMethod.GET, params = {"busq"})
    public ModelAndView buscarFiguritas(@RequestParam String busq){

        ModelMap modelo = new ModelMap();

        modelo.put("busq", busq);

        return new ModelAndView("buscarFiguritas", modelo);
    }



    @RequestMapping(path = "/carta", method = RequestMethod.GET)
    public ModelAndView verCarta(){

        return new ModelAndView("figurita");
    }


}
