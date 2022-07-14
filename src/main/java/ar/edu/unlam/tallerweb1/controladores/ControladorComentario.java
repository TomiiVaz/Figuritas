package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.excepciones.ComentarioException;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorComentario {


    private final ServicioComentario servicioComent;
    private final ServicioFigurita servicioFigu;
    private final ServicioRegistroPegada servicioRP;

    private final ServicioSession servicioSession;

    @Autowired
    public ControladorComentario(ServicioComentario servicioComent, ServicioFigurita servicioFigu, ServicioRegistroPegada servicioRP, ServicioSession servicioSession) {
        this.servicioComent = servicioComent;
        this.servicioFigu = servicioFigu;
        this.servicioRP = servicioRP;
        this.servicioSession = servicioSession;
    }

    @RequestMapping(path = "/carta/agregar-comentario", method = RequestMethod.POST)
    public ModelAndView agregarComentario(@ModelAttribute("comentario") Comentario comentario, HttpServletRequest request) {

        RegistroPegada rpfigurita = comentario.getRegistroPegada();

        try{
            this.servicioComent.agregarComentario(comentario);
        }catch (ComentarioException e){
            return ComentarioFallido(rpfigurita, request, "comentarioVacio", "Debe ingresar un comentario, dato obligatorio!");
        }


        return new ModelAndView("redirect:/home");
    }

    private ModelAndView ComentarioFallido(RegistroPegada rpfigurita, HttpServletRequest request, String errorNombre, String errorMensaje) {

        List<Comentario> comentariosFiltrados = this.servicioComent.traerComentariosPorID(rpfigurita.getId());
        RegistroPegada rp = servicioRP.buscarRegistroId(rpfigurita.getId());
        ModelMap model = new ModelMap();
        model.put("registro", rp);
        model.put("usuario", servicioSession.getUser(request));
        model.put("id", servicioSession.getId(request));
        model.put("rol", servicioSession.getRol(request));
        model.put("comentariosFiltrados", comentariosFiltrados);

        model.put(errorNombre, errorMensaje);


        return new ModelAndView("figurita", model);
    }

}
