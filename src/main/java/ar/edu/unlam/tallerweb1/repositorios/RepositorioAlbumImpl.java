package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
