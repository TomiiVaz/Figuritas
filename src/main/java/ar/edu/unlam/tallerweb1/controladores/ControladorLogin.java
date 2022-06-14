package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.excepciones.ContraseñasDistintasException;
import ar.edu.unlam.tallerweb1.excepciones.LongitudIncorrectaException;
import ar.edu.unlam.tallerweb1.excepciones.UsuarioMailExistenteException;
import ar.edu.unlam.tallerweb1.modelo.RegistroPegada;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorLogin {

    // La anotacion @Autowired indica a Spring que se debe utilizar el contructor como mecanismo de inyección de dependencias,
    // es decir, qeue lo parametros del mismo deben ser un bean de spring y el framewrok automaticamente pasa como parametro
    // el bean correspondiente, en este caso, un objeto de una clase que implemente la interface ServicioLogin,
    // dicha clase debe estar anotada como @Service o @Repository y debe estar en un paquete de los indicados en
    // applicationContext.xml
    private final ServicioLogin servicioLogin;
    private final ServicioSeleccion servicioSeleccion;
    private final ServicioFigurita servicioFigu;

    private final ServicioRegistroPegada serviciopegada;

    @Autowired
    public ControladorLogin(ServicioLogin servicioLogin, ServicioSeleccion servicioSeleccion, ServicioFigurita servicioFigu, ServicioRegistroPegada serviciopegada) {
        this.servicioLogin = servicioLogin;
        this.servicioSeleccion = servicioSeleccion;
        this.servicioFigu = servicioFigu;
        this.serviciopegada = serviciopegada;
    }

    // Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
    @RequestMapping("/login")
    public ModelAndView irALogin() {

        ModelMap modelo = new ModelMap();
        // Se agrega al modelo un objeto con key 'datosLogin' para que el mismo sea asociado
        // al model attribute del form que esta definido en la vista 'login'
        modelo.put("datosLogin", new DatosLogin());
        // Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
        // y se envian los datos a la misma  dentro del modelo
        return new ModelAndView("login", modelo);
    }

    // Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST
    // El metodo recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
    // tag form:form
    @RequestMapping(path = "/validar-login", method = RequestMethod.POST)
    public ModelAndView validarLogin(@ModelAttribute("datosLogin") DatosLogin datosLogin, HttpServletRequest request) {
        ModelMap model = new ModelMap();

        // invoca el metodo consultarUsuario del servicio y hace un redirect a la URL /home, esto es, en lugar de enviar a una vista
        // hace una llamada a otro action a traves de la URL correspondiente a esta
        Usuario usuarioBuscado = servicioLogin.consultarUsuario(datosLogin.getEmail(), datosLogin.getPassword());
        if (usuarioBuscado != null) {
            request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
            // para guardar el id del usuario que se loguea
            request.getSession().setAttribute("ID", usuarioBuscado.getId());
            // para guardar el objeto usario
            request.getSession().setAttribute("USUARIO", usuarioBuscado);
            return new ModelAndView("redirect:/home");
        } else {
            // si el usuario no existe agrega un mensaje de error en el modelo.
            model.put("error", "Usuario o clave incorrecta");
        }
        return new ModelAndView("login", model);
    }

    // Escucha la URL /home por GET, y redirige a una vista.
    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public ModelAndView irAHome(HttpServletRequest request) {


        String rol = (String) request.getSession().getAttribute("ROL");
        Long id = (Long) request.getSession().getAttribute("ID");
        Usuario userLogueado = (Usuario) request.getSession().getAttribute("USUARIO");

        List<RegistroPegada> intercambiables = serviciopegada.getIntercambiables(userLogueado);

        ModelMap model = new ModelMap();
        model.put("intercambiables", intercambiables);
        model.put("usuario", userLogueado);
        model.put("id", id);
        model.put("rol", rol);


        return new ModelAndView("home", model);
    }

    // Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView inicio() {
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(path = "/registrarse", method = RequestMethod.GET)
    public ModelAndView registrarse() {
        List<Seleccion> selecciones = this.servicioSeleccion.traerSelecciones();
        ModelMap model = new ModelMap();
        model.put("selecciones", selecciones);
        return new ModelAndView("registroUsuario", model);
    }

    @RequestMapping(path = "/registrarme", method = RequestMethod.POST)
    public ModelAndView guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {

        ModelMap model = new ModelMap();
        try {
            usuario.setRol("CLI");
            servicioLogin.registrarUsuario(usuario);
        } catch (UsuarioMailExistenteException usuarioMailExistenteException) {
            return registroFallido(model, "Usuario existente con mail ingresado", usuario,"registroFallido");
        } catch (ContraseñasDistintasException e){
            return registroFallido(model, "Las contraseñas deben ser iguales", usuario,"contrasenasDistintas");
        } catch (LongitudIncorrectaException e){
            return registroFallido(model, "La contraseña debe tener al menos 8 carateres", usuario, "longitudIncorrecta");
        }
        return registroExitoso();
    }

    private ModelAndView registroExitoso(){return new ModelAndView("redirect:/home");};

    private ModelAndView registroFallido(ModelMap model, String mensaje, Usuario usuario, String nombreError){
        model.put(nombreError,mensaje);
        model.put("usuario", usuario);
        model.put("selecciones", servicioSeleccion.traerSelecciones());
        return new ModelAndView("registroUsuario", model);
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public ModelAndView guardarUsuario(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ModelAndView("redirect:/home");
    }
}
