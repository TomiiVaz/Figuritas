package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioFigurita")
public class RepositorioFiguritaImpl implements RepositorioFigurita{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioFiguritaImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Integer codigo) {
        sessionFactory.getCurrentSession().save(codigo);
    }

    @Override
    public Figurita findByNombreAndEquipo(String nombre, String equipo) {
        return null;
    }
}
