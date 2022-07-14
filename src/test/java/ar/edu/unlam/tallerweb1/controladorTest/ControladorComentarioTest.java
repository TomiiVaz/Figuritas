package ar.edu.unlam.tallerweb1.controladorTest;

import ar.edu.unlam.tallerweb1.controladores.ControladorComentario;
import ar.edu.unlam.tallerweb1.excepciones.ComentarioException;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioComentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFigurita;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroPegada;
import ar.edu.unlam.tallerweb1.servicios.ServicioSession;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorComentarioTest {

    private final ServicioComentario servicioComentario = mock(ServicioComentario.class);
    private final ServicioFigurita servicioFigurita = mock(ServicioFigurita.class);
    private final ServicioRegistroPegada servicioRegistroPegada = mock(ServicioRegistroPegada.class);

    private final ServicioSession servicioSession = mock(ServicioSession.class);

    private final ControladorComentario controladorComentario = new ControladorComentario(servicioComentario, servicioFigurita, servicioRegistroPegada, servicioSession);


    private ModelAndView mav = new ModelAndView();

    private final HttpServletRequest mockRequest = mock(HttpServletRequest.class);
    private final HttpSession mockSession = mock(HttpSession.class);


    @Test
    public void queSePuedaAgregarUnComentario(){

        // Preparacion -> given
        Comentario comentario = new Comentario();

        // Ejecucion -> when

        whenSeCreaUnComentario(comentario);

        // Comprobacion -> then
        thenQueLaVistaSeaRedirect();

    }

    private void whenSeCreaUnComentario(Comentario comentario) {
        definirComportamientoMocksSession();

        mav = this.controladorComentario.agregarComentario(comentario, mockRequest);
    }

    private void definirComportamientoMocksSession() {
        when(mockRequest.getSession()).thenReturn(mockSession);
        when(mockRequest.getSession().getAttribute("ROL")).thenReturn("ADM");
        when(mockRequest.getSession().getAttribute("ID")).thenReturn(1L);
        when(mockRequest.getSession().getAttribute("USUARIO")).thenReturn(new Usuario());



    }

    private void thenQueLaVistaSeaRedirect() {
        assertThat(mav.getViewName()).isEqualTo("redirect:/home");
    }


    @Test
    public void queNoSePuedaAgregarElComentarioYLanceLaExcepcion(){

        // Preparacion -> given
        Comentario comentario = new Comentario();
        RegistroPegada rpfigurita = new RegistroPegada();
        rpfigurita.setId(1L);
        comentario.setRegistroPegada(rpfigurita); // el comentario necesita tener seteado un RegistroPegada

        // Ejecucion -> when
        doThrow(ComentarioException.class)
                .when(servicioComentario)
                .agregarComentario(comentario);

        whenSeCreaUnComentario(comentario);

        // Comprobacion -> then
        thenQueLaVistaSeaFigurita();


    }

    private void thenQueLaVistaSeaFigurita() {
        assertThat(mav.getViewName()).isEqualTo("figurita");
    }


}
