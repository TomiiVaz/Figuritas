package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioFigurita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorAlbum {

    private ServicioAlbum servicioAl;

    @Autowired
    public ControladorAlbum(ServicioAlbum serviciAl) {

        this.servicioAl = servicioAl;
    }

    @RequestMapping(path = "/ver-album", method = RequestMethod.GET)
    public ModelAndView verAlbum() {

        //servicioAl.pegarFigurita(new Figurita());

        return new ModelAndView("perfil");
    }

    @RequestMapping(path = "/buscar-figurita-en-album", method = RequestMethod.GET)
    public ModelAndView buscarFiguEnAlbum() {

        //servicioAl.buscarFiguritaPorCodigo(555);
        return new ModelAndView("perfil");
    }

    @RequestMapping(path = "/buscar-figurita-en-album-nombre", method = RequestMethod.GET)
    public ModelAndView buscarFiguEnAlbumPorNombre() {

        //servicioAl.buscarFigusPorNombre("Lionel 'D10S' Messi");
        return new ModelAndView("perfil");
    }

    @RequestMapping(path = "/buscar-figuritas-en-album-equipo", method = RequestMethod.GET)
    public ModelAndView buscarFigusEnAlbumPorEquipo() {

        //servicioAl.buscarFigusPorEquipo(22);
        return new ModelAndView("perfil");
    }

    @RequestMapping(path = "/configuracion-album", method = RequestMethod.GET)
    public ModelAndView verVistaAlbumConfig() {
        return new ModelAndView("configAlbum");
    }


}
