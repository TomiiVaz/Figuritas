package ar.edu.unlam.tallerweb1.repositorioTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class RepositorioAlbumTest extends SpringTest {

    @Autowired
    private RepositorioAlbum repositorioAlbum;

    @Test
    @Transactional
    @Rollback
    public void queSePuedaBuscarUnAlbumPorNombre() {
        // Preparacion -> given
        String nombre = "Prueba";
        Album album = new Album();
        album.setNombre(nombre);
        // Ejecucion -> when
        session().save(album);
        Album albumBuscado = repositorioAlbum.getAlbum(nombre);
        // Comprobacion -> then
        assertThat(albumBuscado).isEqualTo(album);
        assertThat(albumBuscado).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaGuardarUnAlbum() {
        // Preparacion -> given
        Album album = new Album();
        // Ejecucion -> when
        session().save(album);
        // Comprobacion -> then
        assertThat(album.getId()).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaBuscarUnAlbumPorId() {
        // Preparacion -> given
        Long id = 1L;
        Album album = new Album();
        album.setId(id);
        // Ejecucion -> when
        session().save(album);
        Album albumBuscado = repositorioAlbum.getAlbum(id);
        // Comprobacion -> then
        assertThat(albumBuscado).isEqualTo(album);
        assertThat(albumBuscado).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaEditarUnAlbum() {
        // Preparacion -> given
        String nombre = "Copa-America-2021";
        Album album = new Album();
        album.setNombre("Qatar-2022");

        // Ejecucion -> when
        session().save(album);
        repositorioAlbum.editarAlbum(album.getId(), nombre);
        Album albumBuscado = repositorioAlbum.getAlbum("Qatar-2022");
        // Comprobacion -> then
        assertThat(albumBuscado).isNull();
        assertThat(album.getNombre()).isEqualTo(nombre);
    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaEliminarUnAlbum() {
        // Preparacion -> given
        Album album = new Album();
        // Ejecucion -> when
        session().save(album);

        repositorioAlbum.eliminarAlbum(album.getId());
        Album albumBuscado = repositorioAlbum.getAlbum(album.getId());
        // Comprobacion -> then
        assertThat(albumBuscado).isNull();
    }

}
