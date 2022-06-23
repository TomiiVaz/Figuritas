package ar.edu.unlam.tallerweb1.repositorioTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSeleccion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioSeleccionTest extends SpringTest {

    @Autowired
    private RepositorioSeleccion repositorioSeleccion;

    @Test
    @Transactional
    @Rollback
    public void queSePuedaBuscarUnAlbumPorNombre() {
        // Preparacion -> given

        // Ejecucion -> when

        // Comprobacion -> then

    }
}
