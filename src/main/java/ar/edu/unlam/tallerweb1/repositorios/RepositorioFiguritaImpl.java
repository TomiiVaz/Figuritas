package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioFigurita")
public class RepositorioFiguritaImpl implements RepositorioFigurita{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioFiguritaImpl(SessionFactory sessionFactory){

        this.sessionFactory = sessionFactory;
    }
    //metodo que va a usar el admin para guardar figuritas
    @Override
    public void guardar(Figurita figurita) {
        sessionFactory.getCurrentSession().save(figurita);
    }

    @Override
    public Figurita findByNombreAndEquipo(String nombre, String equipo) {
        // esperar a ver el cambio de equipo por objeto seleccion
        final Session session = sessionFactory.getCurrentSession();
        return (Figurita) session.createCriteria(Figurita.class)
                .add(Restrictions.eq("nombre", nombre))
                .add(Restrictions.eq("equipo", equipo))
                .uniqueResult();
    }

    @Override
    public Figurita findByNombre(String nombre) {
        final Session session = sessionFactory.getCurrentSession();

        return (Figurita) session.createCriteria(Figurita.class)
                .add(Restrictions.eq("nombre", nombre))
                .list(); // ¿para que traiga una lista?????
    }

    @Override
    public List<Figurita> findAllByIdEquipo(Integer idEquipo) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Figurita>) session.createCriteria(Figurita.class)
                .createAlias("album", "album")
                .add(Restrictions.eq("album.id", idEquipo))
                .list();
    }
}
