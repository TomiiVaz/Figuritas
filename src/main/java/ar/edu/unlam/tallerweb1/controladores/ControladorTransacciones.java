package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.RegistroPegada;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorTransacciones {

    private final ServicioFigurita servicioFigu;
    private final ServicioSeleccion servicioSelec;
    private final ServicioAlbum servicioAlbum;

    private final ServicioLogin servicioLogin;
    private final ServicioRegistroPegada servicioRegistroPegada;

    private final ServicioComentario servicioComent;

    @Autowired
    public ControladorTransacciones(ServicioFigurita servicioFigu, ServicioSeleccion servicioSelec, ServicioAlbum servicioAlbum, ServicioLogin servicioLogin, ServicioRegistroPegada servicioRegistroPegada, ServicioComentario servicioComent) {

        this.servicioFigu = servicioFigu;
        this.servicioSelec = servicioSelec;
        this.servicioAlbum = servicioAlbum;
        this.servicioLogin = servicioLogin;
        this.servicioRegistroPegada = servicioRegistroPegada;
        this.servicioComent = servicioComent;
    }

    @RequestMapping(path = "/publicar/{pegada.id}", method = RequestMethod.GET)
    public ModelAndView publicarFigu(@PathVariable(value = "pegada.id") Long idRegistro){
        RegistroPegada rp = servicioRegistroPegada.buscarRegistroId(idRegistro);
        rp.setIntercambiable(true);
        servicioRegistroPegada.pegarRegistro(rp);
        return new ModelAndView("redirect:/perfil");
    }
}
