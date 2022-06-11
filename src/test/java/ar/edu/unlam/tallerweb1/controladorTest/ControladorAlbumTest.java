package ar.edu.unlam.tallerweb1.controladorTest;


import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorAlbum;
import ar.edu.unlam.tallerweb1.excepciones.AlbumRepetidoException;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ControladorAlbumTest extends SpringTest {

    private ServicioAlbum SA = mock(ServicioAlbum.class);
    private ControladorAlbum CA = new ControladorAlbum(SA);
    private ModelAndView mav;

    @Test
    public void queSePuedaAgregarUnAlbumTest() {
        // Preparacion -> given

        // Ejecucion -> when
        Album album = new Album();
        mav = CA.agregarAlbum(album);

        // Comprobacion -> then
        assertThat(mav.getViewName()).isEqualTo("redirect:/configuracion-album");
    }

    @Test
    public void agregarUnAlbumRepetidoYEsteFalle() {
        // Preparacion -> given

        // Ejecucion -> when
        Album album = new Album();

        doThrow(AlbumRepetidoException.class)
                .when(SA)
                .agregarAlbum(album);

        mav = CA.agregarAlbum(album);

        // Comprobacion -> then
        assertThat(mav.getModel().get("error")).isEqualTo("El nombre del album está en uso");
    }


}
