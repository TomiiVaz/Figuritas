package ar.edu.unlam.tallerweb1.controladorTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorFigurita;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ControladorFiguritaTest extends SpringTest {



    private final ServicioFigurita servicioFigurita = mock(ServicioFigurita.class);
    private final ServicioSeleccion servicioSeleccion = mock(ServicioSeleccion.class);
    private final ServicioAlbum servicioAlbum = mock(ServicioAlbum.class);
    private final ServicioUsuario servicioUsuario = mock(ServicioUsuario.class);
    private final ServicioRegistroPegada servicioRegistroPegada = mock(ServicioRegistroPegada.class);
    private final ServicioComentario servicioComentario = mock(ServicioComentario.class);
    private final ControladorFigurita controladorFigurita = new ControladorFigurita(servicioFigurita, servicioSeleccion, servicioAlbum, servicioUsuario, servicioRegistroPegada, servicioComentario);


    private ModelAndView mav = new ModelAndView();

    @Test
    public void queSePuedaCrearUnaFiguritaCorrectamente(){

        // Preparacion -> given
        Figurita figurita = new Figurita();

        // Ejecucion -> when

        whenSeCreaUnaFigurita(figurita);

        // Comprobacion -> then
        thenQueLaVistaSeaRedirect();

    }
    private void whenSeCreaUnaFigurita(Figurita figurita) {
        mav = this.controladorFigurita.crearFigurita(figurita, (HttpServletRequest) null);
    }
    private void thenQueLaVistaSeaRedirect() {
        assertThat(mav.getViewName()).isEqualTo("redirect:/configuracion-figurita");
    }

    

}
