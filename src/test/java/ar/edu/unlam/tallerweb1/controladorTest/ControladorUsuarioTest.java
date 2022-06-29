package ar.edu.unlam.tallerweb1.controladorTest;

import ar.edu.unlam.tallerweb1.controladores.ControladorUsuario;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroPegada;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;


public class ControladorUsuarioTest {

    private ModelAndView modelAndView;
    private ServicioUsuario servicioUsuario = mock(ServicioUsuario.class);
    private ServicioSeleccion servicioSeleccion = mock(ServicioSeleccion.class);
    private ServicioRegistroPegada servicioRegistroPegada = mock(ServicioRegistroPegada.class);
    private ControladorUsuario controladorUsuario = new ControladorUsuario(servicioUsuario, servicioSeleccion, servicioRegistroPegada);
    private final HttpServletRequest mockRequest = mock(HttpServletRequest.class);
    private final HttpSession mockSession = mock(HttpSession.class);

    @Test
    public void queSePuedaEditarUnPerfil() {
        // Preparacion -> given

        // Ejecucion -> when
        Usuario user = new Usuario();
        user.setId(1L);
        user.setNombre("Tomas");
        user.setRol("CLI");
        user.setPassword("12345678");
        user.setPassword2("12345678");
        controladorUsuario.editarPerfil(user, mockRequest);
        servicioUsuario.modificarDatosUsuario(user);
        mockRequest.getSession().setAttribute("USUARIO", user);
        // Comprobacion -> then
        assertThat(modelAndView.getViewName()).isEqualTo("redirect:/perfil/");
    }
}
