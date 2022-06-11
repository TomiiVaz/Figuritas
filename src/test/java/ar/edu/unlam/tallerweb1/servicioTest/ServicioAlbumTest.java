package ar.edu.unlam.tallerweb1.servicioTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.excepciones.AlbumRepetidoException;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbumImpl;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioAlbumTest extends SpringTest {

    private RepositorioAlbum RA = mock(RepositorioAlbum.class);
    private ServicioAlbum SA = new ServicioAlbumImpl(RA);

    @Test
    public void queSePuedaAgregarUnAlbum() {
        // Preparacion -> given

        // Ejecucion -> when
        Album album = new Album();

        when(RA.getAlbum(album.getNombre())).thenReturn(null);

        SA.agregarAlbum(album);
        // Comprobacion -> then
        assertThat(album).isNotNull();
    }

    @Test(expected = AlbumRepetidoException.class)
    public void alQuererAgregarUnAlbumRepetidoFalla() {
        // Preparacion -> given

        // Ejecucion -> when
        Album album = new Album();
        album.setNombre("Qatar");

        when(RA.getAlbum(album.getNombre())).thenReturn(new Album());

        SA.agregarAlbum(album);
        // Comprobacion -> then
    }
}
