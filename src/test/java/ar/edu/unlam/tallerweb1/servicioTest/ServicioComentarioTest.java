package ar.edu.unlam.tallerweb1.servicioTest;



import ar.edu.unlam.tallerweb1.excepciones.ComentarioException;
import ar.edu.unlam.tallerweb1.excepciones.FiguritaConNombreRepetidoException;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioComentario;
import ar.edu.unlam.tallerweb1.servicios.ServicioComentarioImpl;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ServicioComentarioTest {


    private final RepositorioComentario repositorioComentario = mock(RepositorioComentario.class);
    private final ServicioComentario servicioComentario = new ServicioComentarioImpl(repositorioComentario);



    @Test
    public void queSePuedaAgregarUnComentario () {

        // Preparacion -> given
        Comentario comentario = new Comentario();

        comentario.setDescripcion("alguna escritura");
        comentario.setRegistroPegada(new RegistroPegada());
        comentario.setUsuario(new Usuario());


        // Ejecucion -> when
        whenSeAgregaUnComentario(comentario);

        // Comprobacion -> then
        thenQueSeHayaUtilizadoElRepositorio(comentario);
    }




    @Test (expected = ComentarioException.class)
    public void queNOSePuedaAgregarUnComentarioYLanceLaExcepcion () {

        // Preparacion -> given
        Comentario comentario = new Comentario();

        comentario.setDescripcion(""); // aca el comentario esta vacio por eso lanza la excepcion
        comentario.setRegistroPegada(new RegistroPegada());
        comentario.setUsuario(new Usuario());


        // Ejecucion -> when
        whenSeAgregaUnComentario(comentario);

        // Comprobacion -> then
        thenQueNOSeHayaUtilizadoElRepo(comentario);
    }



    private void whenSeAgregaUnComentario(Comentario comentario) {
        this.servicioComentario.agregarComentario(comentario);
    }

    private void thenQueSeHayaUtilizadoElRepositorio(Comentario comentario) {
        verify(repositorioComentario, atLeastOnce()).guardar(comentario);
    }

    private void thenQueNOSeHayaUtilizadoElRepo(Comentario comentario) {
        verify(repositorioComentario, never()).guardar(comentario);
    }



}

