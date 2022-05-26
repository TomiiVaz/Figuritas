package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Figurita;
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

    //    Le pide al repo que le de los albunes
    @Override
    public List<Album> traerAlbunes() {
        List<Album> albunes = repoAlbum.traerAlbunes();
        return albunes;
    }

}
