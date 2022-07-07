package ar.edu.unlam.tallerweb1.servicioTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.excepciones.AlbumNullDeletedException;
import ar.edu.unlam.tallerweb1.excepciones.AlbumRepetidoException;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbumImpl;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioAlbumTest {

    private RepositorioAlbum repositorioAlbum = mock(RepositorioAlbum.class);
    private ServicioAlbum servicioAlbum = new ServicioAlbumImpl(repositorioAlbum);


    @Test
    public void queSePuedaAgregarUnAlbum() {
        // Preparacion -> given

        // Ejecucion -> when
        Album album = new Album();
        album.setNombre("aa");

        when(repositorioAlbum.getAlbum(album.getNombre())).thenReturn(null);

        servicioAlbum.agregarAlbum(album);
        // Comprobacion -> then
        assertThat(album).isNotNull();
        verify(repositorioAlbum, atLeastOnce()).guardar(album);
    }

    @Test(expected = AlbumRepetidoException.class)
    public void alQuererAgregarUnAlbumRepetidoFalla() {
        // Preparacion -> given

        // Ejecucion -> when
        Album album = new Album();
        album.setNombre("Qatar");

        when(repositorioAlbum.getAlbum(album.getNombre())).thenReturn(new Album());

        servicioAlbum.agregarAlbum(album);
        // Comprobacion -> then
        verify(repositorioAlbum, never()).guardar(album);
    }

    @Test
    public void queSePuedaEditarUnAlbum() {
        // Preparacion -> given

        // Ejecucion -> when
        String nombreAsignado = "pepe";
        Long id = 1L;

        when(repositorioAlbum.getAlbum(nombreAsignado)).thenReturn(null);

        servicioAlbum.editarAlbum(id, nombreAsignado);
        // Comprobacion -> then
        verify(repositorioAlbum, atLeastOnce()).editarAlbum(id, nombreAsignado);
        // times 1
    }

    @Test(expected = AlbumRepetidoException.class)
    public void queNoSePuedaEditarUnAlbumPorNombreExistente() {
        // Preparacion -> given

        // Ejecucion -> when
        Album album = new Album();
        String nombre = "Aldo";
        when(repositorioAlbum.getAlbum(nombre)).thenReturn(new Album());

        servicioAlbum.editarAlbum(1L, nombre);
        // Comprobacion -> then
        verify(repositorioAlbum, never()).editarAlbum(1L, nombre);
    }

    @Test
    public void queSePuedaEliminarElAlbum() {
        // Preparacion -> given

        // Ejecucion -> when
        servicioAlbum.eliminarAlbum(1L);

        // Comprobacion -> then
        verify(repositorioAlbum, atLeastOnce()).eliminarAlbum(1L);
    }

    @Test(expected = AlbumNullDeletedException.class)
    public void queNoSePuedaEliminarAlbumConIdCero() {
        // Preparacion -> given

        // Ejecucion -> when
        servicioAlbum.eliminarAlbum(0L);

        // Comprobacion -> then
        verify(repositorioAlbum, never()).eliminarAlbum(0l);
    }
}
