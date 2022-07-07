package ar.edu.unlam.tallerweb1.controladorTest;

import ar.edu.unlam.tallerweb1.controladores.ControladorGeneral;
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
import static org.mockito.Mockito.*;


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
        when(mockRequest.getSession()).thenReturn(mockSession);
        when(ControladorGeneral.getSessionUserLog(mockRequest)).thenReturn(new Usuario());
        modelAndView = controladorUsuario.editarPerfil(user, mockRequest);
        // Comprobacion -> then
        assertThat(modelAndView.getViewName()).isEqualTo("redirect:/perfil/");
        verify(servicioUsuario, times(1)).modificarDatosUsuario(user);
    }
}
