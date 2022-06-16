package ar.edu.unlam.tallerweb1.servicioTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.excepciones.FiguritaConDorsalNoValidoExcepition;
import ar.edu.unlam.tallerweb1.excepciones.FiguritaConNombreNullOVacioException;
import ar.edu.unlam.tallerweb1.excepciones.FiguritaConNombreRepetidoException;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFigurita;
import ar.edu.unlam.tallerweb1.servicios.ServicioFigurita;
import ar.edu.unlam.tallerweb1.servicios.ServicioFiguritaImpl;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ServicioFiguritaTest  {

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

        //Figurita completa
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

        //Figurita INCOMPLETA le falta el nombre por eso lanza Exception
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


    @Test(expected = FiguritaConDorsalNoValidoExcepition.class)
    public void queNoSePuedaAgregarUnafiguritaPorqueQuiereEligioUnDorsalFueraDeRangoYLanceFiguritaConDorsalNoValidoExcepition () {

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

        //Figurita Con dato erroneo para que lance la Exception
        figurita.setNombre("Roman");
        figurita.setDorsal((byte) 125); //este es el dorsal No Valido porque tiene que ser 0 < Dorsal <= 99
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

    @Test(expected = FiguritaConNombreRepetidoException.class)
    public void queNoSePuedaAgregarUnafiguritaPorqueElNombreDeLaFiguritaYaExisteYLanceFiguritaConNombreRepetidoException () {

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

        //Figurita completa
        figurita.setNombre("Roman");
        figurita.setDorsal((byte) 14);
        figurita.setEquipo("boca");
        figurita.setAlbum(album);
        figurita.setSeleccion(seleccion);
        figurita.setRareza(rareza);
        figurita.setPosicion(posicion);

        when(this.repositorioFigurita.buscarFiguritaPorNombre(figurita.getNombre())).thenReturn(new Figurita());

        // Ejecucion -> when
        whenSeCreaUnaFigurita(figurita);

        // Comprobacion -> then
        thenQueNOSeHayaUtilizadoElRepositorio(figurita); // no llega aca esto se puede borrar
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
