package ar.edu.unlam.tallerweb1.repositorioTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSeleccion;
import org.jetbrains.annotations.NotNull;
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
    public void queSeGuardeUnaSeleccion() {
        // Preparacion -> given
        Seleccion seleccion = getSeleccion();
        // Ejecucion -> when
        repositorioSeleccion.guardar(seleccion);
        // Comprobacion -> then
        assertThat(seleccion.getId()).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    public void queSeElimineUnaSeleccion(){
        Seleccion seleccion = getSeleccion();

        session().save(seleccion);
        repositorioSeleccion.eliminarSeleccion(seleccion.getId());

        assertThat(repositorioSeleccion.getSeleccionPorId(seleccion.getId())).isNull();
    }

    @Test
    @Transactional
    @Rollback
    public void queSeEditeUnaSeleccion(){
        Seleccion seleccion = getSeleccion();

        session().save(seleccion);
        assertThat(repositorioSeleccion.getSeleccionPorId(1l).getNombre()).isEqualTo("Argentina");

        repositorioSeleccion.editarSeleccion(1l, "Scaloneta");

        assertThat(repositorioSeleccion.getSeleccionPorId(1l).getNombre()).isEqualTo("Scaloneta");
    }


    private Seleccion getSeleccion() {
        Seleccion seleccion = new Seleccion();
        seleccion.setNombre("Argetina");
        return seleccion;
    }
}
