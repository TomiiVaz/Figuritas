package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.excepciones.*;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccion;
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
public class ControladorSeleccion {

    private final ServicioSeleccion servicioSelec;
    private final ServicioAlbum servicioAlbum;

    @Autowired
    public ControladorSeleccion(ServicioSeleccion servicioSelec, ServicioAlbum servicioAlbum) {
        this.servicioSelec = servicioSelec;
        this.servicioAlbum = servicioAlbum;
    }

    @RequestMapping(path = "/configuracion/seleccion/", method = RequestMethod.GET)
    public ModelAndView verVistaSeleccionConfig(HttpServletRequest request) {
        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();
        List<Album> albunes = this.servicioAlbum.traerAlbunes();
        String rol = ControladorGeneral.getSessionRol(request);
        Long id = ControladorGeneral.getSessionId(request);
        Usuario userLogueado = ControladorGeneral.getSessionUserLog(request);

        if (!rol.equals("ADM")) {
            return new ModelAndView("redirect:/");
        }

        ModelMap model = new ModelMap();
        model.put("usuario", userLogueado);
        model.put("id", id);
        model.put("rol", rol);
        model.put("albunes", albunes);
        model.put("selecciones", selecciones);

        return new ModelAndView("configSeleccion", model);
    }

    @RequestMapping(path = "/configuracion/seleccion/agregar", method = RequestMethod.POST)
    public ModelAndView crearSeleccion(@ModelAttribute("selecciones") Seleccion seleccion) {
        try {
            this.servicioSelec.crearSeleccion(seleccion);
            return new ModelAndView("redirect:/configuracion/seleccion/");
        } catch (SeleccionCamposVacíosException e){
            return getModelAndView("No se ha completado ningun campo.");
        } catch (SeleccionAlbumNullException e) {
            return getModelAndView("No ha seleccionado un album.");
        } catch (SeleccionNombreVacioException e){
            return getModelAndView("El campo nombre está vacío.");
        } catch (SeleccionNombreTieneNumerosOCaracteresEspecialesException e){
            return getModelAndView("El nombre no puede contener números ni caracteres especiales");
        }

    }

    @RequestMapping(path = "/configuracion/seleccion/editar", method = RequestMethod.POST, params = {"seleccionId", "nombreNuevo"})
    public ModelAndView verSelecciones(@RequestParam int seleccionId,
                                       @RequestParam String nombreNuevo) {
        try {
            this.servicioSelec.editarSeleccion((long) seleccionId, nombreNuevo);
            return new ModelAndView("redirect:/configuracion/seleccion/");
        } catch (SeleccionSelectorNoUsado e){
            return getModelAndView("Elija una seleccion a editar.");
        } catch (SeleccionNombreVacioException e){
            return getModelAndView("El campo Nombre no puede estar vacío.");
        } catch (SeleccionNombreEnUsoException e){
            return getModelAndView("El nombre ya está en uso.");
        } catch (SeleccionNombreTieneNumerosOCaracteresEspecialesException e){
            return getModelAndView("El nombre no puede contener números ni caracteres especiales");
        }
    }

    @RequestMapping(path = "/configuracion/seleccion/eliminar", method = RequestMethod.POST, params = {"seleccionId"})
    public ModelAndView delSelecciones(@RequestParam int seleccionId) {
        try {
            this.servicioSelec.eliminarSeleccion((long) seleccionId);
            return new ModelAndView("redirect:/configuracion/seleccion/");
        } catch (SeleccionSelectorNoUsado e){
            return getModelAndView("Elija una selección a eliminar");
        }
    }

    private ModelAndView getModelAndView(String value) {
        ModelMap model = new ModelMap();
        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();
        List<Album> albunes = this.servicioAlbum.traerAlbunes();
        model.put("albunes", albunes);
        model.put("selecciones", selecciones);
        model.put("error", value);
        return new ModelAndView("configSeleccion", model);
    }

}
