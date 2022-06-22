package ar.edu.unlam.tallerweb1.servicioTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.excepciones.CodigoIncorrectoExcepcion;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.RegistroPegada;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroPegada;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroPegada;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroPegadaImpl;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioRegistroPegadaTest extends SpringTest {
    private final RepositorioRegistroPegada repositorioRegistroPegada = mock(RepositorioRegistroPegada.class);

    private final ServicioRegistroPegada servicioRegistroPegada = new ServicioRegistroPegadaImpl(repositorioRegistroPegada);


    @Test
    public void queFunque(){
        assertThat(true).isEqualTo(true);
    }

    @Test
    public void queSePuedaPegarUnRegistro(){
    //preparacion -> given
    RegistroPegada regPegada = new RegistroPegada();
    Figurita figurita = new Figurita();
    Album album = new Album();
    album.setNombre("a");
    figurita.setAlbum(album);

    regPegada.setId(1L);
    regPegada.setAlbum(album);
    regPegada.setUsuario(new Usuario());
    regPegada.setIntercambiable(true);
    regPegada.setFigurita(figurita);

    //ejecucion -> when
    whenSePegaUnRegistro(regPegada);

    //comprobacion -> then
    thenVerificarQueSeAccedioAlRepositorioParaCrearUnRegPegada(regPegada);
    }

    @Test(expected = CodigoIncorrectoExcepcion.class)
    public void queNoSePuedaPegarUnRegistroSiElCodigoEsIncorrecto(){
        //preparacion -> given
        RegistroPegada regPegada = new RegistroPegada();
        Figurita figurita = new Figurita();
        Album album = new Album();
        album.setNombre("a");
        figurita.setAlbum(album);

        regPegada.setId(1L);
        regPegada.setAlbum(album);
        regPegada.setUsuario(new Usuario());
        regPegada.setIntercambiable(true);
        regPegada.setFigurita(figurita);


        regPegada.setFigurita(null); //si no tiene figurita asociada, es porque el codigo está mal

        //ejecucion -> when

        whenSePegaUnRegistro(regPegada);

        //comprobacion -> then
        thenVerificarQueNoSeAccedioAlRepositorio(regPegada);
    }

    @Test
    public void queSePuedanObtenerLosRegistrosIntercambiablesSinHaberIniciadoSesion(){
        //preparacion -> given

        //ejecucion -> when
        when(repositorioRegistroPegada.traerFiguritasIntercambiables()).thenReturn(new ArrayList<RegistroPegada>() );

        servicioRegistroPegada.getIntercambiables( null);
        //comprobacion -> then
        thenVerificarQueSeAccedioAlRepoParaPedirRegPegadasSinIniciarSesion();
    }

    @Test
    public void queSePuedanObtenerLosRegistrosIntercambiablesHabiendoIniciadoSesion(){
        //preparacion -> given
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        //ejecucion -> when
        when(repositorioRegistroPegada.traerFiguritasIntercambiables(usuario)).thenReturn(new ArrayList<RegistroPegada>() );

        servicioRegistroPegada.getIntercambiables(usuario);

        //comprobacion -> then
        thenVerificarQueSeAccedioAlRepoParaPedirRegPegadasConSesionIniciada(usuario);
    }



    private void thenVerificarQueSeAccedioAlRepoParaPedirRegPegadasConSesionIniciada(Usuario usuario) {
        verify(repositorioRegistroPegada, atLeastOnce()).traerFiguritasIntercambiables(usuario);
    }

    private void thenVerificarQueSeAccedioAlRepoParaPedirRegPegadasSinIniciarSesion() {
        verify(repositorioRegistroPegada, atLeastOnce()).traerFiguritasIntercambiables();
    }

    private void thenVerificarQueNoSeAccedioAlRepositorio(RegistroPegada regPegada) {
        verify(repositorioRegistroPegada, never()).update(regPegada);
    }

    private void thenVerificarQueSeAccedioAlRepositorioParaCrearUnRegPegada(RegistroPegada regPegada) {
        verify(repositorioRegistroPegada, atLeastOnce()).update(regPegada);
    }

    private void whenSePegaUnRegistro(RegistroPegada regPegada) {
        servicioRegistroPegada.pegarRegistro(regPegada);
    }

}
