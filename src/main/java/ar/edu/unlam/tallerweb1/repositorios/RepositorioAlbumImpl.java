package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Figurita;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioAlbum")
public class RepositorioAlbumImpl implements RepositorioAlbum {

    private final SessionFactory sessionFactory;

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

    @Override
    public void editarAlbum(Long albumId, String nombreNuevo) {
        final Session session = sessionFactory.getCurrentSession();

        //Busco el album con la id pasada
        Album album = (Album) session.createCriteria(Album.class)
                .add(Restrictions.eq("id", albumId))
                .uniqueResult();

        //Le cambio el nommbre
        album.setNombre(nombreNuevo);

        //Lo pongo en la db
        session.update(album);
    }

    @Override
    public void eliminarAlbum(long albumId) {
        final Session session = sessionFactory.getCurrentSession();

        Album album = (Album) session.createCriteria(Album.class)
                .add(Restrictions.eq("id", albumId))
                .uniqueResult();

        session.delete(album);
    }

    @Override
    public Album getAlbum(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (Album) session.createCriteria(Album.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public Album getAlbum(String nombre) {
        final Session session = sessionFactory.getCurrentSession();
        return (Album) session.createCriteria(Album.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

    @Override
    public int getCantidadDeFiguritaDeUnAlbum(String nombreAlbum){
        final Session session = sessionFactory.getCurrentSession();
        List<Figurita> figuritas = (List<Figurita>) session.createCriteria(Figurita.class)
                .createAlias("album","a")
                .add(Restrictions.eq("a.nombre",nombreAlbum))
                .list();

        return figuritas.size();
    }

}
