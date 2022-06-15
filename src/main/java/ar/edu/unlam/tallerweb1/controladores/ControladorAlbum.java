package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.excepciones.*;
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

    @RequestMapping(path = "/configuracion-album", method = RequestMethod.GET)
    public ModelAndView verAlbum(HttpServletRequest request) {
        List<Album> albunes = this.servicioAl.traerAlbunes();
        String rol = (String) request.getSession().getAttribute("ROL");
        Long id = (Long) request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario) request.getSession().getAttribute("USUARIO");

        ModelMap model = new ModelMap();
        model.put("usuario", userLogueado);
        model.put("id", id);
        model.put("rol", rol);
        model.put("albunes", albunes);
        return new ModelAndView("configAlbum", model);
    }

    @RequestMapping(path = "/agregar-album", method = RequestMethod.POST)
    public ModelAndView agregarAlbum(@ModelAttribute("album") Album album) {
        try {
            servicioAl.agregarAlbum(album);
            return new ModelAndView("redirect:/configuracion-album");
        } catch (AlbumNombreVacioException e) {
            return getModelAndView("El campo de nombre está vacio");
        } catch (AlbumRepetidoException e) {
            return getModelAndView("El nombre del album está en uso");
        }
    }

    @RequestMapping(path = "/editar-album", method = RequestMethod.POST)
    public ModelAndView editarAlbunes(@RequestParam int albumId,
                                      @RequestParam String nombreNuevo) {
        try {
            this.servicioAl.editarAlbum((long) albumId, nombreNuevo);
            return new ModelAndView("redirect:/configuracion-album");
        } catch (AlbumEditarTodoNulo e) {
            return getModelAndView("Todos los campos estan vacios");
        } catch (AlbumIdVacioException e) {
            return getModelAndView("No ha seleccionado ningun album");
        } catch (AlbumNombreVacioException e) {
            return getModelAndView("El campo de nombre está vacio");
        } catch (AlbumRepetidoException e) {
            return getModelAndView("El nombre del album está en uso");
        }
    }

    @RequestMapping(path = "/eliminar-album", method = RequestMethod.POST)
    public ModelAndView eliminarAlbum(@RequestParam long albumId) {
        System.out.println(albumId);
        try {
            this.servicioAl.eliminarAlbum(albumId);
            return new ModelAndView("redirect:/configuracion-album");
        } catch (AlbumNullDeletedException e) {
            return getModelAndView("Para eliminar, seleccione un album");
        }
    }

    private ModelAndView getModelAndView(String value) {
        ModelMap model = new ModelMap();
        List<Album> albunes = this.servicioAl.traerAlbunes();
        model.put("albunes", albunes);
        model.put("error", value);
        return new ModelAndView("configAlbum", model);
    }

}
