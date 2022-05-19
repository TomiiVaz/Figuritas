package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioSeleccion")
public class RepositorioSeleccionImpl implements RepositorioSeleccion {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioSeleccionImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void guardar(Seleccion seleccion) {

        this.sessionFactory.getCurrentSession().save(seleccion);
    }

    @Override
    public List<Seleccion> getSelecciones() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Seleccion>) session.createCriteria(Seleccion.class)
                .list();
    } // ?????????????????????
}
