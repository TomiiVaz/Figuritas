package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// implelemtacion del repositorio de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
@Repository("repositorioUsuario")
public class RepositorioUsuarioImpl implements RepositorioUsuario {

    // Maneja acciones de persistencia, normalmente estara inyectado el session factory de hibernate
    // el mismo esta difinido en el archivo hibernateContext.xml
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioUsuarioImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Usuario buscarUsuario(String email, String password) {

        // Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
        // de busqueda de Usuario donde el email y password sean iguales a los del objeto recibido como parametro
        // uniqueResult da error si se encuentran mas de un resultado en la busqueda.
        final Session session = sessionFactory.getCurrentSession();
        return (Usuario) session.createCriteria(Usuario.class)
                .add(Restrictions.eq("email", email))
                .add(Restrictions.eq("password", password))
                .uniqueResult();
    }

    @Override
    public void guardar(Usuario usuario) {
        sessionFactory.getCurrentSession().save(usuario);
    }

    @Override
    public Usuario buscar(String email) {
        return (Usuario) sessionFactory.getCurrentSession().createCriteria(Usuario.class)
                .add(Restrictions.eq("email", email))
                .uniqueResult();
    }

    @Override
    public List<String> getMailUsuario() {
        final Session session = sessionFactory.getCurrentSession();

        return (List<String>) session.createNativeQuery("select email from usuario")
                .list();

    }

    @Override
    public Usuario getUsuario(String mail) {
        final Session session = sessionFactory.getCurrentSession();
        return (Usuario) session.createCriteria(Usuario.class)
                .add(Restrictions.eq("email", mail))
                .uniqueResult();
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        final Session session = sessionFactory.getCurrentSession();
        session.update(usuario);
    }

    @Override
    public List<Usuario> traerUsuarios() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Usuario>) session.createCriteria(Usuario.class)
                .add(Restrictions.eq("activo",false))
                .list();
    }

    @Override
    public void delete(Usuario usuario) {
        sessionFactory.getCurrentSession().delete(usuario);
    }

    @Override
    public Usuario getUsuario(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (Usuario) session.createCriteria(Usuario.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

}
