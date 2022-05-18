package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
