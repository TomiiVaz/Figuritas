package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.RegistroIntercambio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public Estado getEstadoId(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (Estado) session.createCriteria(Estado.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();
    }
}
