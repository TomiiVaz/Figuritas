package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.excepciones.AlbumRepetidoException;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorAlbum {

    private final ServicioAlbum servicioAl;

    @Autowired
    public ControladorAlbum(ServicioAlbum serviciAl) {

        this.servicioAl = serviciAl;
    }


    //    Para poder agregar un album a la base de datos
    @RequestMapping(path = "/agregar-album", method = RequestMethod.POST)
    public ModelAndView agregarAlbum(@ModelAttribute("album") Album album) {
        try {
            servicioAl.verificarAlbum(album.getNombre());
            servicioAl.agregarAlbum(album);
            return new ModelAndView("redirect:/configuracion-album");
        } catch (AlbumRepetidoException albumRepetidoException) {
            ModelMap model = new ModelMap();
            List<Album> albunes = this.servicioAl.traerAlbunes();
            model.put("albunes", albunes);
            model.put("error", albumRepetidoException.getMessage());
            return new ModelAndView("configAlbum", model);
        }
    }


    //    Para que me traiga todos los albunes de la base de datos
    @RequestMapping(path = "/configuracion-album", method = RequestMethod.GET)
    public ModelAndView verAlbum(HttpServletRequest request) {
        List<Album> albunes = this.servicioAl.traerAlbunes();
        String rol = (String) request.getSession().getAttribute("ROL");
        Long id = (Long) request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario) request.getSession().getAttribute("USUARIO");

        ModelMap model = new ModelMap();
        model.put("albunes", albunes);
        model.put("usuario", userLogueado);
        model.put("id", id);
        model.put("rol", rol);
        return new ModelAndView("configAlbum", model);
    }

    @RequestMapping(path = "/editar-album", method = RequestMethod.POST, params = {"album.id", "nombreNuevo"})
    public ModelAndView editarAlbunes(@RequestParam int albumId,
                                      @RequestParam String nombreNuevo) {

        this.servicioAl.editarAlbum((long) albumId, nombreNuevo);

        return new ModelAndView("redirect:/configuracion-album");
    }

    @RequestMapping(path = "/eliminar-album", method = RequestMethod.POST, params = {"album.id"})
    public ModelAndView eliminarAlbum(@RequestParam int albumId) {

        this.servicioAl.eliminarAlbum(albumId);

        return new ModelAndView("redirect:/configuracion-album");
    }

}
