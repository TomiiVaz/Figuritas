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
    private ServicioAlbumImpl(RepositorioAlbum repoAlbum) {
        this.repoAlbum = repoAlbum;
    }

    //   Le habla al repo para que guarde en db el albun
    @Override
    public void agregarAlbum(Album album) {
        repoAlbum.guardar(album);
    }

    @Override
    public void verificarAlbum(String nombre) {
        if (this.repoAlbum.getAlbum(nombre) != null) {
            throw new AlbumRepetidoException("El nombre del album está en uso");
        }
    }


    //    Le pide al repo que le de los albunes
    @Override
    public List<Album> traerAlbunes() {
        return repoAlbum.traerAlbunes();
    }

    @Override
    public void editarAlbum(Long albumId, String nombreNuevo) {
        if (this.repoAlbum.getAlbum(nombreNuevo) != null) {
            throw new AlbumRepetidoException("El nombre del album está en uso");
        } else this.repoAlbum.editarAlbum(albumId, nombreNuevo);
    }

    @Override
    public void eliminarAlbum(Long albumId) {
        if (albumId == 0) {
            throw new AlbumNullDeletedException("Para eliminar, seleccione un album");
        } else this.repoAlbum.eliminarAlbum(albumId);
    }

    @Override
    public Album getAlbum(Long id) {
        return repoAlbum.getAlbum(id);
    }

}
