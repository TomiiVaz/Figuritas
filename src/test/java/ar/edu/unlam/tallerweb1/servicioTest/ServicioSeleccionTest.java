package ar.edu.unlam.tallerweb1.servicioTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSeleccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccionImpl;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioSeleccionTest extends SpringTest {

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
}
