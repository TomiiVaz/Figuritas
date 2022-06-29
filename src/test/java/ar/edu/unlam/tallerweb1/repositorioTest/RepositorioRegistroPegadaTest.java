package ar.edu.unlam.tallerweb1.repositorioTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.RegistroPegada;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroPegadaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioImpl;
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

    @Autowired
    private RepositorioUsuarioImpl repositorioUsuario;


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
        RegistroPegada registroPegada = crearUnRegPegada(1l,1l,1l,true);

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
        RegistroPegada registroPegada = crearUnRegPegada(1l,1l,1l,true);

        repositorioRegistroPegada.pegar(registroPegada);

        /*Ejecucion*/
        RegistroPegada registroPegadaBuscado = repositorioRegistroPegada.getRegistroPorId(registroPegada.getId());
        /*Comprobacion*/
        assertThat(registroPegada).isEqualTo(registroPegadaBuscado);

    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaBuscarFiguritasIntercambiablesSinHaberseLogeado(){
        /*Preparacion*/
        RegistroPegada registroPegada_1 = crearUnRegPegada(1l,1l,1l,true);
        RegistroPegada registroPegada_2 = crearUnRegPegada(2l,3l,1l,true);
        RegistroPegada registroPegada_3 = crearUnRegPegada(1l,2l,1l,false);

        repositorioRegistroPegada.pegar(registroPegada_1);
        repositorioRegistroPegada.pegar(registroPegada_2);
        //repositorioRegistroPegada.pegar(registroPegada_3);

        /*Ejecucion*/
        List<RegistroPegada> registrosPegadasEncontradas = repositorioRegistroPegada.traerFiguritasIntercambiables();
        /*Comprobacion*/
        assertThat( registrosPegadasEncontradas.size() ).isGreaterThanOrEqualTo(2);

    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaBuscarMisFiguritasIntercambiablesEstandoLogueado(){
        /*Preparacion*/

        RegistroPegada registroPegada_1 = crearUnRegPegada(1l,1l,1l,true);
        RegistroPegada registroPegada_2 = crearUnRegPegada(4l,3l,1l,true);
        RegistroPegada registroPegada_3 = crearUnRegPegada(1l,2l,1l,false);

        repositorioRegistroPegada.pegar(registroPegada_1);
        repositorioRegistroPegada.pegar(registroPegada_2);
        repositorioRegistroPegada.pegar(registroPegada_3);

        /*Ejecucion*/
        List<RegistroPegada> registrosPegadasEncontradas = repositorioRegistroPegada.traerFiguritasPegadasPorUsuario(registroPegada_2.getUsuario().getId());

        /*Comprobacion*/
        assertThat( registrosPegadasEncontradas.size() ).isEqualTo(1);
    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaBuscarFiguritasIntercambiablesQueNoSeanDelUsuario(){

        /*Preparacion*/
        RegistroPegada registroPegada_1 = crearUnRegPegada(1l,1l,1l,true);
        RegistroPegada registroPegada_2 = crearUnRegPegada(4l,3l,1l,true);
        RegistroPegada registroPegada_3 = crearUnRegPegada(2l,2l,1l,false);
        RegistroPegada registroPegada_4 = crearUnRegPegada(2l,2l,1l,true);

        repositorioRegistroPegada.pegar(registroPegada_1);
        repositorioRegistroPegada.pegar(registroPegada_2);
        repositorioRegistroPegada.pegar(registroPegada_3);
        repositorioRegistroPegada.pegar(registroPegada_4);


        /*Ejecucion*/
        List<RegistroPegada> registrosPegadasEncontradas = repositorioRegistroPegada.traerFiguritasIntercambiablesParaBusqueda(registroPegada_1.getUsuario().getId());

        /*Comprobacion*/
        assertThat( registrosPegadasEncontradas.size() ).isGreaterThanOrEqualTo(2);

    }


    private RegistroPegada crearUnRegPegada(Long idUsuario, Long idFigurita, Long idAlbum, boolean isIntercambiable){
        RegistroPegada registroPegada = new RegistroPegada();

        Usuario usuario = new Usuario();
        Figurita figurita = new Figurita();
        Album album = new Album();

        usuario.setId(idUsuario);
        figurita.setId(idFigurita);
        album.setId(idAlbum);

        Usuario userBuscado = repositorioUsuario.getUsuario(idUsuario);
        if( userBuscado == null)
            repositorioUsuario.guardar(usuario);

        registroPegada.setUsuario(usuario);
        registroPegada.setFigurita(figurita);
        registroPegada.setIntercambiable(isIntercambiable);
        registroPegada.setAlbum(album);

        return registroPegada;
    }


}
