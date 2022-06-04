package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.Figurita;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioComentario")
public class RepositorioComentarioImpl implements RepositorioComentario{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioComentarioImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Comentario comentario) {
        this.sessionFactory.getCurrentSession().save(comentario);


    }

    @Override
    public List<Comentario> getComentarios() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Comentario>) session.createCriteria(Comentario.class)
                .list();
    }

    @Override
    public List<Comentario> getComentariosPorId(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Comentario>) session.createCriteria(Comentario.class)
                .add(Restrictions.eq("figurita.id", id))
                .list();
    }
}
