package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import org.hibernate.SessionFactory;
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

    @Override
    public void guardar(Figurita figurita) {
        sessionFactory.getCurrentSession().save(figurita);
    }

    @Override
    public Figurita findByNombreAndEquipo(String nombre, String equipo) {
        return null;
    }

    @Override
    public Figurita findByNombre(String nombre) {
        // preguntar por metodo como findByNombre
        return null;
    }

    @Override
    public List<Figurita> findAllByIdEquipo(Integer idEquipo) {
        // preguntar por metodo como findByAllByIdEquipo
        return null;
    }
}
