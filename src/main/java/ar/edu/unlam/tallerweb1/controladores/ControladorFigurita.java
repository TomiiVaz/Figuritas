package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioFigurita;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorFigurita {

    private ServicioFigurita servicioFigu;
    private ServicioSeleccion servicioSelec;
    private ServicioAlbum servicioAlbum;

    @Autowired
    public ControladorFigurita(ServicioFigurita servicioFigu, ServicioSeleccion servicioSelec, ServicioAlbum servicioAlbum) {

        this.servicioFigu = servicioFigu;
        this.servicioSelec = servicioSelec;
        this.servicioAlbum = servicioAlbum;
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
        List<Posicion> posiciones = this.servicioFigu.traerPosiciones();
        List<Rareza> rarezas = this.servicioFigu.traerRarezas();
        List<Album> albunes = this.servicioAlbum.traerAlbunes();
        List<Figurita> figuritas = this.servicioFigu.traerFiguritas();

        ModelMap model = new ModelMap();
        model.put("selecciones", selecciones);
        model.put("rarezas", rarezas);
        model.put("posiciones", posiciones);
        model.put("albunes", albunes);
        model.put("figuritas", figuritas);

        return new ModelAndView("configFigurita", model);
    }

    @RequestMapping(path = "/editar-figurita", method = RequestMethod.POST)
    public ModelAndView editarFigurita(@RequestParam("figuritaId") Long figuritaId, HttpServletRequest request) {

        //buscarfigurita y mandar al model map
        Figurita figuritaEncontrada=this.servicioFigu.buscarFigurita(figuritaId);
        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();
        List<Posicion> posiciones = this.servicioFigu.traerPosiciones();
        List<Rareza> rarezas = this.servicioFigu.traerRarezas();
        List<Album> albunes = this.servicioAlbum.traerAlbunes();

        ModelMap model = new ModelMap();
        model.put("figuritaEncontrada", figuritaEncontrada);
        model.put("selecciones", selecciones);
        model.put("rarezas", rarezas);
        model.put("posiciones", posiciones);
        model.put("albunes", albunes);

        return new ModelAndView("editarFigurita", model);
    }

    @RequestMapping(path = "/crear-figurita", method = RequestMethod.POST)
    public ModelAndView crearFigurita(@ModelAttribute("figurita") Figurita figurita, HttpServletRequest request) {

        this.servicioFigu.agregarFigurita(figurita);

        return new ModelAndView("redirect:/configuracion-figurita");
    }

    @RequestMapping(path = "/updateFalso-figurita", method = RequestMethod.POST)
    public ModelAndView crearFigurita(@ModelAttribute("figurita") Figurita figurita, @RequestParam int id, HttpServletRequest request) {
        this.servicioFigu.eliminarFigurita((long)id);
        this.servicioFigu.agregarFigurita(figurita);

        return new ModelAndView("redirect:/configuracion-figurita");
    }

    @RequestMapping(path = "/ver-figurita" , method = RequestMethod.POST, params = {"figuritaId","figuritaNueva"})
    public ModelAndView verFigurita(@RequestParam int figuritaId,
                                    @ModelAttribute Figurita figurita){
        figurita.setId((long)figuritaId);
        this.servicioFigu.agregarFigurita(figurita);

        return new ModelAndView("redirect:/configuracion-figurita");
    }

    @RequestMapping(path = "/del-figurita" , method = RequestMethod.POST, params = {"figuritaId"})
    public ModelAndView delFigurita(@RequestParam int figuritaId){

        this.servicioFigu.eliminarFigurita((long)figuritaId);

        return new ModelAndView("redirect:/configuracion-figurita");
    }

    /*@RequestMapping(path = "/buscarfiguritas", method = RequestMethod.GET, params = {"busq","sel","pos"})
    public ModelAndView buscarFiguritas(@RequestParam String busq,
                                        @RequestParam String sel,
                                        @RequestParam String pos){
        ModelMap resBusqueda = new ModelMap();

        List<Figurita> figuritasEncontradas = new ArrayList<>();

        figuritasEncontradas.add(servicioFigu.buscarFiguritaPorNombre(busq));

        resBusqueda.put("figEncontradas",figuritasEncontradas);

        return new ModelAndView("buscarFiguritas", resBusqueda);
    }*/


    @RequestMapping(path = "/buscarfiguritas", method = RequestMethod.GET, params = {"busq"})
    public ModelAndView buscarFiguritas(@RequestParam String busq){

        ModelMap resBusqueda = new ModelMap();

        List<Figurita> figs = servicioFigu.buscarFiguritaPorNombre(busq);
        resBusqueda.put("figEncontradas", figs);

        return new ModelAndView("buscarFiguritas", resBusqueda);
    }
}
