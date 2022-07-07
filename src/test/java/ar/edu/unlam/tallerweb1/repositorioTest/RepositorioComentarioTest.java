package ar.edu.unlam.tallerweb1.repositorioTest;

import ar.edu.unlam.tallerweb1.SpringTest;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComentario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioComentarioTest extends SpringTest {

    @Autowired
    private RepositorioComentario repositorioComentario;


    @Test
    @Transactional
    @Rollback
    public void queSePuedaGuardaUnComentarioEnElRepo(){

        // Preparacion -> given
        Comentario comentario = new Comentario();

        // Ejecucion -> when
        session().save(comentario);
       // repositorioComentario.guardar(comentario);

        // Comprobacion -> then
        assertThat(comentario.getId()).isNotNull();
    }



}
