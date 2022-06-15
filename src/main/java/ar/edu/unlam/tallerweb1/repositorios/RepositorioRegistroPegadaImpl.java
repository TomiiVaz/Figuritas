package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.RegistroPegada;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
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
    public void update(RegistroPegada rp) {
        sessionFactory.getCurrentSession().update(rp);
    }

    @Override
    public List<RegistroPegada> traerFiguritasPegadasPorUsuario(Long idUsuario) {

        final Session session = sessionFactory.getCurrentSession();
        return (List<RegistroPegada>) session.createCriteria(RegistroPegada.class)
                .createAlias("usuario","usuario")
                .add(Restrictions.eq("usuario.id", idUsuario))
                .list();
    }

    @Override
    public List<RegistroPegada> traerFiguritasIntercambiables(Usuario usuario) {
        final Session session = sessionFactory.getCurrentSession();

        return (List<RegistroPegada>) session.createCriteria(RegistroPegada.class)
                .add(Restrictions.eq("intercambiable", true))
                .add(Restrictions.ne("usuario.id", usuario.getId()))
                .list();
    }

    @Override
    public List<RegistroPegada> traerFiguritasIntercambiables() {
        final Session session = sessionFactory.getCurrentSession();

        return (List<RegistroPegada>) session.createCriteria(RegistroPegada.class)
                .add(Restrictions.eq("intercambiable", true))
                .list();
    }

    @Override
    public RegistroPegada getRegistroPorId(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (RegistroPegada) session.createCriteria(RegistroPegada.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public List<RegistroPegada> getRegistroPorNombreFigurita(String nombre){
        final Session session = sessionFactory.getCurrentSession();

        List<RegistroPegada> registroPegadas =
                (List<RegistroPegada>) session.createCriteria(RegistroPegada.class)
                .createAlias("figurita", "f")
                .add(Restrictions.eq("f.nombre", nombre))
                .list();
        return registroPegadas;
    }

    @Override
    public List<RegistroPegada> getRegistroPorSeleccionFigurita(Long seleccion){
        final Session session = sessionFactory.getCurrentSession();
        return (List<RegistroPegada>)session.createCriteria(RegistroPegada.class)
                .createAlias("figurita", "f")
                .createAlias("f.seleccion", "s")
                .add(Restrictions.eq("s.id" , seleccion))
                .list();
    }

    @Override
    public List<RegistroPegada> getRegistroPorAlbumFigurita(Long album, Long idUsuario) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<RegistroPegada>)session.createCriteria(RegistroPegada.class)
                .createAlias("figurita", "f")
                .createAlias("f.album", "a")
                .createAlias("usuario", "u")
                .add(Restrictions.eq("a.id" , album))
                .add(Restrictions.eq("u.id" , idUsuario))
                .list();
    }

    @Override
    public List<RegistroPegada> getRegistroPorPosicionFigurita(Long posicion){
        final Session session = sessionFactory.getCurrentSession();
        return (List<RegistroPegada>)session.createCriteria(RegistroPegada.class)
                .createAlias("figurita", "f")
                .createAlias("f.posicion", "p")
                .add(Restrictions.eq("p.id" , posicion))
                .list();
    }

    @Override
    public List<RegistroPegada> getRegistroPorSeleccionFiguritaUsuario(Long seleccion, Long idUsuario) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<RegistroPegada>)session.createCriteria(RegistroPegada.class)
                .createAlias("figurita", "f")
                .createAlias("f.seleccion", "s")
                .createAlias("usuario", "u")
                .add(Restrictions.eq("s.id" , seleccion))
                .add(Restrictions.eq("u.id" , idUsuario))
                .list();
    }
}
