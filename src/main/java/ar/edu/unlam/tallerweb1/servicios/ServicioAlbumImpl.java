package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.excepciones.*;
import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioAlbum")
@Transactional
public class ServicioAlbumImpl implements ServicioAlbum {

    private final RepositorioAlbum repoAlbum;

    @Autowired
    public ServicioAlbumImpl(RepositorioAlbum repoAlbum) {
        this.repoAlbum = repoAlbum;
    }

    //   Le habla al repo para que guarde en db el albun
    @Override
    public void agregarAlbum(Album album) {
        if (this.repoAlbum.getAlbum(album.getNombre()) != null) {
            throw new AlbumRepetidoException();
        }
        if (album.getNombre().length() == 0) {
            throw new AlbumNombreVacioException();
        }
        repoAlbum.guardar(album);
    }

    @Override
    public List<Album> traerAlbunes() {
        return repoAlbum.traerAlbunes();
    }

    @Override
    public void editarAlbum(Long albumId, String nombreNuevo) {
        if (albumId == 0 && nombreNuevo.length() == 0) {
            throw new AlbumEditarTodoNulo();
        }
        if (albumId == 0) {
            throw new AlbumIdVacioException();
        }
        if (this.repoAlbum.getAlbum(nombreNuevo) != null) {
            throw new AlbumRepetidoException();
        }
        if (nombreNuevo.length() == 0) {
            throw new AlbumNombreVacioException();
        }
        this.repoAlbum.editarAlbum(albumId, nombreNuevo);
    }

    @Override
    public void eliminarAlbum(Long albumId) {
        if (albumId == 0) {
            throw new AlbumNullDeletedException();
        }
        this.repoAlbum.eliminarAlbum(albumId);
    }

    @Override
    public Album getAlbum(Long id) {
        return repoAlbum.getAlbum(id);
    }

}
