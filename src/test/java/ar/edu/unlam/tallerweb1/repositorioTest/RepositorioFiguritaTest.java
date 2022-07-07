package ar.edu.unlam.tallerweb1.repositorioTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFigurita;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RepositorioFiguritaTest extends SpringTest {

    @Autowired
    private RepositorioFigurita repositorioFigurita;

    @Test
    @Transactional
    @Rollback
    public void queSePuedaGuardaUnaFiguritaEnElRepositorioCorrectamente(){

        // Preparacion -> given
        Figurita figurita = new Figurita();
        figurita.setNombre("Roman");

        // Ejecucion -> when
        repositorioFigurita.guardar(figurita);

        // Comprobacion -> then
        assertThat(figurita.getId()).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaBuscarUnaFiguritaPorNombre(){

        // Preparacion -> given
        Figurita figurita = new Figurita();
        figurita.setNombre("Roman");

        // Ejecucion -> when
        session().save(figurita);
        Figurita figuritaBuscada = repositorioFigurita.buscarFiguritaPorNombre("Roman");

        // Comprobacion -> then
        assertThat(figuritaBuscada).isEqualTo(figurita);
        assertThat(figuritaBuscada).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaEliminarUnaFiguritaPorID(){

        // Preparacion -> given
        Figurita figurita = new Figurita();
        figurita.setNombre("Roman");

        // Ejecucion -> when
        session().save(figurita);

        assertThat(repositorioFigurita.buscarFiguritaPorNombre("Roman")).isNotNull(); //aca chequeo que la figurita fue guardada correctamente y la busque

        repositorioFigurita.eliminarFigurita(figurita.getId());

        // Comprobacion -> then
        assertThat(repositorioFigurita.buscarFiguritaPorNombre("Roman")).isNull(); // aca no la encuentra porque ya no existe

    }


    @Test
    @Transactional
    @Rollback
    public void queSePuedaEncontrarUnaFiguritaPorID(){

        // Preparacion -> given
        Figurita figurita = new Figurita();
        figurita.setNombre("Roman");

        // Ejecucion -> when
        session().save(figurita);

        Figurita figuritaEncontrada = repositorioFigurita.buscarFiguritaPorID(figurita.getId()); //aca chequeo que la encuentre por ID

        // Comprobacion -> then
        assertThat(figuritaEncontrada).isNotNull(); // aca chequeo que la encuentre
        assertThat(figuritaEncontrada.getNombre()).isEqualTo("Roman");

    }


}
