package ar.edu.unlam.tallerweb1.servicioTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.excepciones.AlbumRepetidoException;
import ar.edu.unlam.tallerweb1.excepciones.SeleccionCamposVacíosException;
import ar.edu.unlam.tallerweb1.excepciones.SeleccionNombreEnUsoException;
import ar.edu.unlam.tallerweb1.excepciones.SeleccionNombreVacioException;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSeleccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccionImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioSeleccionTest{

    private final String redirectCorrectoSeleccion = "redirect:/configuracion/seleccion/";
    private final String redirectInorrectoSeleccion = "configSeleccion";
    private final String errorCaracteresNumerosSeleccion = "El nombre no puede contener números ni caracteres especiales";
    private RepositorioSeleccion repositorioSeleccion = mock(RepositorioSeleccion.class);
    private ServicioSeleccion servicioSeleccion= new ServicioSeleccionImpl(repositorioSeleccion);

    @Test
    public void queSePuedaAgregarUnaSeleccionTest(){
        //preparacion -> given
        Seleccion seleccion = givenUnaSeleccion();
        seleccion.setNombre("arg");
        Album album = new Album();
        album.setId(8l);
        album.setNombre("dasda");
        seleccion.setAlbum(album);
        //ejecucion -> when

        whenAgregoUnaSeleccion(seleccion);

        //comprobacion -> then
        assertThat(seleccion).isNotNull();
        verify(repositorioSeleccion, atLeastOnce()).guardar(seleccion);
    }

    private void thenRedirectCorrectoSeleccion() {
    }

    private void whenAgregoUnaSeleccion(Seleccion seleccion) {
        servicioSeleccion.crearSeleccion(seleccion);
    }

    private Seleccion givenUnaSeleccion() {
        return new Seleccion();
    }

    @Test(expected = SeleccionCamposVacíosException.class)
    public void alQuererAgregarConCamposVaciosFalla(){
        Seleccion seleccion = givenUnaSeleccion();
        Album album = new Album();
        album.setId(0l);
        seleccion.setAlbum(album);
        seleccion.setNombre("");
        seleccion.setId(0l);
        //when(repositorioSeleccion.getSeleccionPorId(seleccion.getId())).thenReturn(seleccion);
        whenAgregoUnaSeleccion(seleccion);

        verify(repositorioSeleccion, never()).guardar(seleccion);
    }

    @Test
    public void queSePuedaEliminarUnaSeleccion(){

        servicioSeleccion.eliminarSeleccion(1l);

        verify(repositorioSeleccion, atLeastOnce()).eliminarSeleccion(1l);
    }

    @Test
    public void queSePuedaTraerTodasLasSeleccionesExistentes(){

        repositorioSeleccion.getSelecciones();

        when(repositorioSeleccion.getSelecciones()).thenReturn(new ArrayList<>());

        verify(repositorioSeleccion).getSelecciones();
    }

    @Test
    public void queSePuedaEditarUnaSeleccion() {
        // Preparacion -> given

        // Ejecucion -> when
        String nombre = "Argentina";
        Long id = 1L;

        when(repositorioSeleccion.getSeleccionPorId(1l)).thenReturn(null);

        servicioSeleccion.editarSeleccion(id, nombre);
        // Comprobacion
        verify(repositorioSeleccion, atLeastOnce()).editarSeleccion(id, nombre);

    }

    @Test(expected = SeleccionNombreVacioException.class)
    public void queNoSePuedaEditarUnaSeleccionPorNombreVacio() {
        // Preparacion -> given

        // Ejecucion -> when
        String nombre = "";

        servicioSeleccion.editarSeleccion(1L, nombre);
        // Comprobacion -> then
        verify(repositorioSeleccion, never()).editarSeleccion(1L, nombre);
    }

    @Test(expected = SeleccionNombreEnUsoException.class)
    public void queNoSePuedaEditarUnaSeleccionPorNombreExistente() {
        // Preparacion -> given

        // Ejecucion -> when
        String nombre = "Argentina";
        List<Seleccion> lista = new ArrayList<>();
        lista.add(new Seleccion());
        when(repositorioSeleccion.getSeleccionesPorNombre(nombre)).thenReturn(lista);

        servicioSeleccion.editarSeleccion(1L, nombre);
        // Comprobacion -> then
        verify(repositorioSeleccion, never()).editarSeleccion(1L, nombre);
    }

}
