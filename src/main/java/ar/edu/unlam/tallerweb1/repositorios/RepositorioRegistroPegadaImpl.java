package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.RegistroPegada;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioRp")
public class RepositorioRegistroPegadaImpl implements RepositorioRegistroPegada {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioRegistroPegadaImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void pegar(RegistroPegada rp) {
        sessionFactory.getCurrentSession().save(rp);
    }
}
