package ar.edu.unlam.tallerweb1.repositorios;

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
    }

    @Override
    public List<Seleccion> getSeleccionesPorNombre(String nombre){
        final Session session = sessionFactory.getCurrentSession();
        return (List<Seleccion>) session.createCriteria(Seleccion.class)
                .add(Restrictions.eq("nombre",nombre))
                .list();
    }

    @Override
    public void editarSeleccion(Long id, String nombreNuevo) {
        final Session session = sessionFactory.getCurrentSession();


        //Busco la seleccion con la id pasada
        Seleccion seleccion = (Seleccion) session.createCriteria(Seleccion.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();

        //Le cambio el nommbre
        seleccion.setNombre(nombreNuevo);

        //Lo pongo en la db
        session.update(seleccion);
    }

    @Override
    public void eliminarSeleccion(Long id) {
        final Session session = sessionFactory.getCurrentSession();

        Seleccion seleccion = (Seleccion) session.createCriteria(Seleccion.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();

        session.delete(seleccion);

    }

    @Override
    public Seleccion getSeleccionPorId(Long id){
        final Session session = sessionFactory.getCurrentSession();

        Seleccion seleccion = (Seleccion) session.createCriteria(Seleccion.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();
        return seleccion;
    }
}
