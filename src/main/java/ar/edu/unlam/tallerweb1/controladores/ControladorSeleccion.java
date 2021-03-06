package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.excepciones.*;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioSession;
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

    private final ServicioSession servicioSession;

    @Autowired
    public ControladorSeleccion(ServicioSeleccion servicioSelec, ServicioAlbum servicioAlbum, ServicioSession servicioSession) {
        this.servicioSelec = servicioSelec;
        this.servicioAlbum = servicioAlbum;
        this.servicioSession = servicioSession;
    }

    @RequestMapping(path = "/configuracion/seleccion/", method = RequestMethod.GET)
    public ModelAndView verVistaSeleccionConfig(HttpServletRequest request) {
        List<Seleccion> selecciones = this.servicioSelec.traerSelecciones();
        List<Album> albunes = this.servicioAlbum.traerAlbunes();
        String rol = ControladorGeneral.getSessionRol(request);
        Long id = ControladorGeneral.getSessionId(request);
        Usuario userLogueado = ControladorGeneral.getSessionUserLog(request);

        if (servicioSession.getRol(request)==null || !servicioSession.getRol(request).equals("ADM")) {
            return new ModelAndView("redirect:/");
        }

        ModelMap model = new ModelMap();
        model.put("usuario", servicioSession.getUser(request));
        model.put("id", servicioSession.getId(request));
        model.put("rol", servicioSession.getRol(request));
        model.put("albunes", albunes);
        model.put("selecciones", selecciones);

        return new ModelAndView("configSeleccion", model);
    }

    @RequestMapping(path = "/configuracion/seleccion/agregar", method = RequestMethod.POST)
    public ModelAndView crearSeleccion(@ModelAttribute("selecciones") Seleccion seleccion) {
        try {
            this.servicioSelec.crearSeleccion(seleccion);
            return new ModelAndView("redirect:/configuracion/seleccion/");
        } catch (SeleccionCamposVac??osException e) {
            return getModelAndView("No se ha completado ningun campo.");
        } catch (SeleccionAlbumNullException e) {
            return getModelAndView("No ha seleccionado un album.");
        } catch (SeleccionNombreVacioException e) {
            return getModelAndView("El campo nombre est?? vac??o.");
        } catch (SeleccionNombreTieneNumerosOCaracteresEspecialesException e) {
            return getModelAndView("El nombre no puede contener n??meros ni caracteres especiales");
        }

    }

    @RequestMapping(path = "/configuracion/seleccion/editar", method = RequestMethod.POST, params = {"seleccionId", "nombreNuevo"})
    public ModelAndView verSelecciones(@RequestParam int seleccionId,
                                       @RequestParam String nombreNuevo) {
        try {
            this.servicioSelec.editarSeleccion((long) seleccionId, nombreNuevo);
            return new ModelAndView("redirect:/configuracion/seleccion/");
        } catch (SeleccionSelectorNoUsado e) {
            return getModelAndView("Elija una seleccion a editar.");
        } catch (SeleccionNombreVacioException e) {
            return getModelAndView("El campo Nombre no puede estar vac??o.");
        } catch (SeleccionNombreEnUsoException e) {
            return getModelAndView("El nombre ya est?? en uso.");
        } catch (SeleccionNombreTieneNumerosOCaracteresEspecialesException e) {
            return getModelAndView("El nombre no puede contener n??meros ni caracteres especiales");
        }
    }

    @RequestMapping(path = "/configuracion/seleccion/eliminar", method = RequestMethod.POST, params = {"seleccionId"})
    public ModelAndView delSelecciones(@RequestParam int seleccionId) {
        try {
            this.servicioSelec.eliminarSeleccion((long) seleccionId);
            return new ModelAndView("redirect:/configuracion/seleccion/");
        } catch (SeleccionSelectorNoUsado e) {
            return getModelAndView("Elija una selecci??n a eliminar");
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
