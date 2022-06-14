package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.excepciones.AlbumNullDeletedException;
import ar.edu.unlam.tallerweb1.excepciones.AlbumRepetidoException;
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
        repoAlbum.guardar(album);
    }

    //    Le pide al repo que le de los albunes
    @Override
    public List<Album> traerAlbunes() {
        return repoAlbum.traerAlbunes();
    }

    @Override
    public void editarAlbum(Long albumId, String nombreNuevo) {
        if (this.repoAlbum.getAlbum(nombreNuevo) != null) {
            throw new AlbumRepetidoException();
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
