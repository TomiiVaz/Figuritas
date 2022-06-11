package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.RegistroPegada;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<RegistroPegada> traerFiguritasPegadasPorUsuario(Long idUsuario) {

        final Session session = sessionFactory.getCurrentSession();
        return (List<RegistroPegada>) session.createCriteria(RegistroPegada.class)
                .createAlias("usuario","usuario")
                .add(Restrictions.eq("usuario.id", idUsuario))
                .list();
    }
}
