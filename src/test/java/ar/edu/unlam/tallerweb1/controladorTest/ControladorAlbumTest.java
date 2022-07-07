package ar.edu.unlam.tallerweb1.controladorTest;


import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorAlbum;
import ar.edu.unlam.tallerweb1.excepciones.AlbumNullDeletedException;
import ar.edu.unlam.tallerweb1.excepciones.AlbumRepetidoException;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ControladorAlbumTest {

    private ServicioAlbum servicioAlbum = mock(ServicioAlbum.class);
    private ControladorAlbum controladorAlbum = new ControladorAlbum(servicioAlbum);
    private ModelAndView modelAndView;

    private final String ERROR_NULO = "Para eliminar, seleccione un album";
    private final String ERROR_REPETIDO = "El nombre del album está en uso";
    private final String NOMBRE_ALBUM = "Prueba";
    private final Long ID_NULO = 0L;
    private final Long ID_NO_NULO_LONG = 1L;
    private final Integer ID_NO_NULO_INT = 1;

    @Test
    public void queSePuedaAgregarUnAlbumTest() {
        // Preparacion -> given

        // Ejecucion -> when
        Album album = new Album();
        whenSeAgregaUnAlbum(album);

        // Comprobacion -> then
        thenQueLaVistaSeaRedirect();

    }

    private void whenSeAgregaUnAlbum(Album album) {
        modelAndView = controladorAlbum.agregarAlbum(album);
    }

    private void thenQueLaVistaSeaRedirect() {
        assertThat(modelAndView.getViewName()).isEqualTo("redirect:/configuracion/album/");
    }

    @Test
    public void agregarUnAlbumRepetidoYEsteFalle() {
        // Preparacion -> given

        // Ejecucion -> when
        Album album = new Album();

        doThrow(AlbumRepetidoException.class)
                .when(servicioAlbum)
                .agregarAlbum(album);

        whenSeAgregaUnAlbum(album);

        // Comprobacion -> then
        thenQueLaDevueltaSeaUnError(ERROR_REPETIDO);

    }

    private void thenQueLaDevueltaSeaUnError(String mensaje) {
        assertThat(modelAndView.getModel().get("error")).isEqualTo(mensaje);
    }

    @Test
    public void sePuedeEditarUnAlbum() {
        // Preparacion -> given

        // Ejecucion -> when;
        whenSeEditaUnAlbum();

        // Comprobacion -> then
        thenQueLaVistaSeaRedirect();
    }

    private void whenSeEditaUnAlbum() {
        modelAndView = controladorAlbum.editarAlbunes(ID_NO_NULO_INT, NOMBRE_ALBUM);
    }

    @Test
    public void noSePuedeEditarAlbumPorNombreExistente() {
        // Preparacion -> given

        // Ejecucion -> when;
        doThrow(AlbumRepetidoException.class)
                .when(servicioAlbum)
                .editarAlbum(ID_NO_NULO_LONG, NOMBRE_ALBUM);

        whenSeEditaUnAlbum();

        // Comprobacion -> then
        thenQueLaDevueltaSeaUnError(ERROR_REPETIDO);
    }

    @Test
    public void sePuedeEliminarUnAlbum() {
        // Preparacion -> given

        // Ejecucion -> when;
        whenSeEliminaUnAlbum(ID_NO_NULO_LONG);


        // Comprobacion -> then

        thenQueLaVistaSeaRedirect();
    }

    private void whenSeEliminaUnAlbum(Long id) {
        modelAndView = controladorAlbum.eliminarAlbum(id);
    }

    @Test
    public void noSePuedeEliminarAlbumPorqueIdEsCeroONulo() {
        // Preparacion -> given

        // Ejecucion -> when;
        doThrow(AlbumNullDeletedException.class)
                .when(servicioAlbum)
                .eliminarAlbum(ID_NULO);

        whenSeEliminaUnAlbum(ID_NULO);

        // Comprobacion -> then
        thenQueLaDevueltaSeaUnError(ERROR_NULO);
    }

}
