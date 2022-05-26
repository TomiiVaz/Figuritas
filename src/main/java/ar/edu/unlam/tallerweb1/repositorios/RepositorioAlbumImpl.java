package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

    @Override
    public void editarAlbum(Long albumId, String nombreNuevo) {
        final Session session = sessionFactory.getCurrentSession();


        //Busco la seleccion con la id pasada
        Seleccion seleccion = (Seleccion) session.createCriteria(Seleccion.class)
                .add(Restrictions.eq("id",albumId))
                .uniqueResult();

        //Le cambio el nommbre
        seleccion.setNombre(nombreNuevo);

        //Lo pongo en la db
        session.update(seleccion);

    }

}
