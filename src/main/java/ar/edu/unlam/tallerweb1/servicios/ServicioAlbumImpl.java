package ar.edu.unlam.tallerweb1.servicios;

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

    private RepositorioAlbum repoAlbum;

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
        List<Album> albunes = repoAlbum.traerAlbunes();
        return albunes;
    }

    @Override
    public void editarAlbum(Long albumId, String nombreNuevo) {
        this.repoAlbum.editarAlbum(albumId, nombreNuevo);
    }

    @Override
    public void eliminarAlbum(long albumId) {
        this.repoAlbum.eliminarAlbum(albumId);
    }

    @Override
    public Album agarrarAlbum(Long id) {
        return repoAlbum.getAlbum(id);
    }

}
