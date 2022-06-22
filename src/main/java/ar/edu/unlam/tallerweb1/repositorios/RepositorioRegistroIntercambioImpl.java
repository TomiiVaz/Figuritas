package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.RegistroIntercambio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioRegistroIntercambio")
public class RepositorioRegistroIntercambioImpl implements RepositorioRegistroIntercambio{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioRegistroIntercambioImpl(SessionFactory sessionFactory){

        this.sessionFactory = sessionFactory;
    }


    @Override
    public void guardar(RegistroIntercambio ri) {

        final Session session = sessionFactory.getCurrentSession();
        session.save(ri);
    }

    @Override
    public void update(RegistroIntercambio ri) {
        final Session session = sessionFactory.getCurrentSession();
        session.update(ri);
    }

    @Override
    public Estado getEstadoId(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (Estado) session.createCriteria(Estado.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();
    }

    @Override
    public List<RegistroIntercambio> traerIntercambiosQueMeHacen(Long idUser) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<RegistroIntercambio>) session.createCriteria(RegistroIntercambio.class)
                .createAlias("registroDecide","rd")
                .createAlias("rd.usuario","usuarioDecide")
                .add(Restrictions.eq("usuarioDecide.id", idUser))
                .list();
    }

    @Override
    public List<RegistroIntercambio> traerIntercambiosQueHago(Long idUser) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<RegistroIntercambio>) session.createCriteria(RegistroIntercambio.class)
                .createAlias("registroPide","rp")
                .createAlias("rp.usuario","usuarioPide")
                .add(Restrictions.eq("usuarioPide.id", idUser))
                .list();
    }

    @Override
    public RegistroIntercambio getRegistroIntercambioId(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (RegistroIntercambio) session.createCriteria(RegistroIntercambio.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();
    }
}
