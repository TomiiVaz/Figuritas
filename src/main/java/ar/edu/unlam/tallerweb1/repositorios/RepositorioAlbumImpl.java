package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioAlbum")
public class RepositorioAlbumImpl implements RepositorioAlbum{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioAlbumImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void agregarFigurita(Figurita figu) {
        sessionFactory.getCurrentSession().save(figu);
    }

    @Override
    public Figurita getFigurita(Integer codigo) {
        //preguntar por metodo con la sessionFactory que sea como findAllByCodigo
        return null;
    }

    @Override
    public List<Figurita> findAllByNombre(String nombre) {
        //preguntar por metodo con la sessionFactory que sea como findAllByNombre
        return null;
    }

    @Override
    public List<Figurita> findAllByEquipo(Integer idEquipo) {
        //preguntar por metodo con la sessionFactory que sea como findAllByEquipo
        return null;
    }
}
