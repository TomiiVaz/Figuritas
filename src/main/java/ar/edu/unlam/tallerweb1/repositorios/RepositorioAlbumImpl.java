package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Figurita;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioAlbum")
public class RepositorioAlbumImpl implements RepositorioAlbum {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioAlbumImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void guardar(Album album) {
        sessionFactory.getCurrentSession().save(album);
    }

    @Override
    public List<Album> traerAlbunes() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Album>) session.createCriteria(Album.class)
                .list();
    }

}
