package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("repositorioFigurita")
public class RepositorioFiguritaImpl implements RepositorioFigurita{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioFiguritaImpl(SessionFactory sessionFactory){

        this.sessionFactory = sessionFactory;
    }
    //metodo que va a usar el admin para guardar figuritas
    @Override
    public void guardar(Figurita figurita) {
        sessionFactory.getCurrentSession().save(figurita);
    }

    @Override
    public Figurita findByNombreAndEquipo(String nombre, String equipo) {
        // esperar a ver el cambio de equipo por objeto seleccion
        final Session session = sessionFactory.getCurrentSession();
        return (Figurita) session.createCriteria(Figurita.class)
                .add(Restrictions.eq("nombre", nombre))
                .add(Restrictions.eq("equipo", equipo))
                .uniqueResult();
    }

    @Override
    public List<Figurita> findByNombre(String nombre) {
        final Session session = sessionFactory.getCurrentSession();

        return (List<Figurita>) session.createCriteria(Figurita.class)
                .add(Restrictions.eq("nombre", nombre))
                .list(); // ¿para que traiga una lista?????
    }

    @Override
    public List<Figurita> findAllByIdEquipo(Integer idEquipo) {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Figurita>) session.createCriteria(Figurita.class)
                .createAlias("album", "album")
                .add(Restrictions.eq("album.id", idEquipo))
                .list();
    }

    @Override
    public List<Posicion> getPosiciones() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Posicion>)session.createCriteria(Posicion.class)
                .list();
    }

    @Override
    public List<Rareza> getRarezas() {
        final Session session = sessionFactory.getCurrentSession();
        return (List<Rareza>)session.createCriteria(Rareza.class)
                .list();
    }

    @Override
    public List<Figurita> getFiguritas() {

        final Session session = sessionFactory.getCurrentSession();
        return (List<Figurita>) session.createCriteria(Figurita.class)
                .list();
    }

    @Override
    public List<Figurita> buscarFiguritaPorFiltros(String nombre, Long seleccion, Long posicion) {
        final Session session = sessionFactory.getCurrentSession();
        List<Figurita> figuritasEncontradas = new ArrayList<>();

        Boolean buscarNombre = (nombre != null && nombre !="");
        Boolean buscarSeleccion = (seleccion != null && seleccion != 0);
        Boolean buscarPosicion = (posicion != null && posicion != 0);

        if(buscarNombre){
            figuritasEncontradas = findByNombre(nombre);
        }

        if(buscarSeleccion){
            List<Figurita> figsPorSeleccion = (List<Figurita>)session.createCriteria(Figurita.class)
                                                .createAlias("seleccion","tablaSel")
                                                    .add(Restrictions.eq("tablaSel.id" , seleccion))
                                                    .list();

            if(figuritasEncontradas.size() > 0){
                for (Figurita fig : figuritasEncontradas) {
                    if(! figsPorSeleccion.contains(fig)){ //Si las figuritas no tienen la selección, borrarla de la lista
                        figuritasEncontradas.remove(fig);
                    }
                    if(figuritasEncontradas.size() <= 0) break;
                }
            }
            else{
                figuritasEncontradas = figsPorSeleccion;
            }

        }

        if(buscarPosicion){
            List<Figurita> figsPorPosicion = (List<Figurita>)session.createCriteria(Figurita.class)
                    .createAlias("posicion","tablaSel")
                    .add(Restrictions.eq("tablaSel.id" , posicion))
                    .list();

            if(figuritasEncontradas.size() > 0){
                for (Figurita fig : figuritasEncontradas) {
                    if(! figsPorPosicion.contains(fig)){ //Si las figuritas no tienen la selección, borrarla de la lista
                        figuritasEncontradas.remove(fig);
                    }
                    if(figuritasEncontradas.size() <= 0) break;
                }
            }
            else{
                figuritasEncontradas = figsPorPosicion;
            }

        }
        return figuritasEncontradas;

    }

    @Override
    public void editarFigurita(long figuritaId, String figuritaNueva) {
        final Session session = sessionFactory.getCurrentSession();



    }

    @Override
    public void eliminarFigurita(long figuritaId) {
        final Session session = sessionFactory.getCurrentSession();

        Figurita figurita = (Figurita) session.createCriteria(Figurita.class)
                .add(Restrictions.eq("id",figuritaId))
                .uniqueResult();

        session.delete(figurita);
    }

    @Override
    public Figurita encontrarFigurita(Long id) {

        final Session session = sessionFactory.getCurrentSession();

        Figurita figurita = (Figurita) session.createCriteria(Figurita.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();

        return figurita;
    }


}
