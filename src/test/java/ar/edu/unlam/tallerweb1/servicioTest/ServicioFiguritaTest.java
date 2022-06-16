package ar.edu.unlam.tallerweb1.servicioTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.excepciones.AlbumRepetidoException;
import ar.edu.unlam.tallerweb1.excepciones.FiguritaConNombreNullOVacioException;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFigurita;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbumImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioFigurita;
import ar.edu.unlam.tallerweb1.servicios.ServicioFiguritaImpl;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

public class ServicioFiguritaTest extends SpringTest {


    private final RepositorioFigurita repositorioFigurita = mock(RepositorioFigurita.class);
    private final ServicioFigurita servicioFigurita = new ServicioFiguritaImpl(repositorioFigurita);

    @Test
    public void queSePuedaAgregarUnaFiguritaCorrectamente () {

        // Preparacion -> given
        Figurita figurita = new Figurita();
        Album album = new Album();
        Seleccion seleccion = new Seleccion();
        Rareza rareza = new Rareza();
        Posicion posicion = new Posicion();

        album.setId(1L);
        seleccion.setId(1L);
        rareza.setId(1L);
        posicion.setId(1L);

        figurita.setNombre("Roman");
        figurita.setDorsal((byte) 1);
        figurita.setEquipo("boca");
        figurita.setAlbum(album);
        figurita.setSeleccion(seleccion);
        figurita.setRareza(rareza);
        figurita.setPosicion(posicion);

        // Ejecucion -> when

        whenSeCreaUnaFigurita(figurita);

        // Comprobacion -> then
        thenQueSeHayaUtilizadoElRepositorio(figurita);
    }



    @Test(expected = FiguritaConNombreNullOVacioException.class)
    public void queNoSePuedaAgregarUnafiguritaPorqueLeFaltaElNombreYLanceFiguritaConNombreNullOVacioException () {

        // Preparacion -> given
        Figurita figurita = new Figurita();
        Album album = new Album();
        Seleccion seleccion = new Seleccion();
        Rareza rareza = new Rareza();
        Posicion posicion = new Posicion();

        album.setId(1L);
        seleccion.setId(1L);
        rareza.setId(1L);
        posicion.setId(1L);

        figurita.setDorsal((byte) 1);
        figurita.setEquipo("boca");
        figurita.setAlbum(album);
        figurita.setSeleccion(seleccion);
        figurita.setRareza(rareza);
        figurita.setPosicion(posicion);

        // Ejecucion -> when

        whenSeCreaUnaFigurita(figurita);

        // Comprobacion -> then
        thenQueNOSeHayaUtilizadoElRepositorio(figurita);
    }

    private void whenSeCreaUnaFigurita(Figurita figurita) {
        this.servicioFigurita.agregarFigurita(figurita);
    }

    private void thenQueSeHayaUtilizadoElRepositorio(Figurita figurita) {
        verify(repositorioFigurita, atLeastOnce()).guardar(figurita);
    }

    private void thenQueNOSeHayaUtilizadoElRepositorio(Figurita figurita) {
        verify(repositorioFigurita, never()).guardar(figurita);
    }


}
