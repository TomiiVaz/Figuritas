package ar.edu.unlam.tallerweb1.repositorioTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.RegistroPegada;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroPegadaImpl;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioRegistroPegadaTest extends SpringTest {

    @Autowired
    private RepositorioRegistroPegadaImpl repositorioRegistroPegada;


    @Test
    @Transactional
    @Rollback
    public void queFunque(){
        assertThat(true).isEqualTo(true);
        /*Preparacion*/


        /*Ejecucion*/


        /*Comprobacion*/
    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaPegarUnaFigurita(){
        /*Preparacion*/
        RegistroPegada registroPegada = new RegistroPegada();

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        Figurita figurita = new Figurita();
        figurita.setId(1L);
        Album album = new Album();
        album.setId(1L);
        registroPegada.setUsuario(usuario);
        registroPegada.setFigurita(figurita);
        registroPegada.setIntercambiable(true);
        registroPegada.setAlbum(album);

        /*Ejecucion*/
        repositorioRegistroPegada.pegar(registroPegada);

        /*Comprobacion*/
        assertThat( registroPegada.getId() ).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaPedirFiguritasIntercambiables(){
        /*Preparacion*/


        /*Ejecucion*/
        List<RegistroPegada> registros = repositorioRegistroPegada.traerFiguritasIntercambiables();

        /*Comprobacion*/
        assertThat(registros.size()).isGreaterThan(0);
    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaPedirFiguritasIntercambiablesQueNoSeanDelUsuario(){
        /*Preparacion*/
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        /*Ejecucion*/
        List<RegistroPegada> registros = repositorioRegistroPegada.traerFiguritasIntercambiables(usuario);
        boolean tienenAlUsuario = false;

        for (RegistroPegada registro: registros ) {
            if(registro.getUsuario().getId() == usuario.getId()){
                tienenAlUsuario = true;
                break;
            }
        }

        /*Comprobacion*/
        assertThat(tienenAlUsuario).isFalse();
    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaObtenerUnRegistroPorSuId(){
        /*Preparacion*/
        RegistroPegada registroPegada = new RegistroPegada();

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        Figurita figurita = new Figurita();
        figurita.setId(1L);
        Album album = new Album();
        album.setId(1L);
        registroPegada.setUsuario(usuario);
        registroPegada.setFigurita(figurita);
        registroPegada.setIntercambiable(true);
        registroPegada.setAlbum(album);

        repositorioRegistroPegada.pegar(registroPegada);

        /*Ejecucion*/
        RegistroPegada registroPegadaBuscado = repositorioRegistroPegada.getRegistroPorId(registroPegada.getId());
        /*Comprobacion*/
        assertThat(registroPegada).isEqualTo(registroPegadaBuscado);

    }


}
