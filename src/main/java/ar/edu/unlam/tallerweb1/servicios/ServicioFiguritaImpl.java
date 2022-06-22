package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.excepciones.*;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFigurita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("servicioFigurita")
@Transactional
public class ServicioFiguritaImpl implements ServicioFigurita{

    private final RepositorioFigurita repoFigurita;

    @Autowired
    public ServicioFiguritaImpl(RepositorioFigurita repoFigurita){
        this.repoFigurita = repoFigurita;
    }


    @Override
    public void agregarFigurita(Figurita figurita) {

        if(verificarQueElcampoNoVengaNullOVacio(figurita.getNombre())){
            throw new FiguritaConNombreNullOVacioException();
        }

        if(verificarNombreFiguritaRepetido(figurita.getNombre())){
            throw new FiguritaConNombreRepetidoException();
        }

        if(verificarQueSeleccionNoVengVacio(figurita.getSeleccion())){
            throw new FiguritaConSeleccionVaciaExcepition();
        }

        if(verificarQueLaPorsicionNoVengaVacia(figurita.getPosicion())){
            throw new FiguritaConPosicionVaciaExcepition();
        }

        if(verificarQueLaRarezaNoVengaVacia(figurita.getRareza())){
            throw new FiguritaConRarezaVaciaExcepition();
        }

        if(verificarQueElAlbumNoVengaVacio(figurita.getAlbum())){
            throw new FiguritaConAlbumVacioExcepition();
        }

        if(verificarQueElDorsalEnRangoValido(figurita.getDorsal())){
            throw new FiguritaConDorsalNoValidoExcepition();
        }

        if(verificarQueElEquipoNoVengVacio(figurita.getEquipo())){
            throw new FiguritaConConEquipoVacioExcepition();
        }


        repoFigurita.guardar(figurita);

    }

    @Override
    public Posicion getPosicionPorId(Long id) {
        return repoFigurita.getPosicionPorId(id);
    }

    private boolean verificarQueElEquipoNoVengVacio(String equipo) {
        return equipo.isEmpty();
    }

    private boolean verificarQueElDorsalEnRangoValido(byte dorsal) {
        return !(dorsal >0 && dorsal <=99);
    }

    private boolean verificarQueElAlbumNoVengaVacio(Album album) {
        boolean respuesta = false;
        if(album == null){
            respuesta = true;
        }

        if(album.getId() == 0){
            respuesta = true;
        }
        return respuesta;
    }

    private boolean verificarQueLaRarezaNoVengaVacia(Rareza rareza) {
        boolean respuesta = false;
        if(rareza == null){
            respuesta = true;
        }
        if(rareza.getId() == 0){
            respuesta = true;
        }
        return respuesta;
    }


    private boolean verificarQueLaPorsicionNoVengaVacia(Posicion posicion) {
        boolean respuesta = false;
        if(posicion == null){
            respuesta = true;
        }
        if(posicion.getId() == 0){
            respuesta = true;
        }
        return respuesta;
    }

    private boolean verificarQueSeleccionNoVengVacio(Seleccion seleccion) {

        boolean respuesta = false;
        if(seleccion == null){
            respuesta = true;
        }
        if(seleccion.getId() == 0){
            respuesta = true;
        }
        return respuesta;
    }

    private boolean verificarQueElcampoNoVengaNullOVacio(String nombre) {
        return nombre == null || nombre.isEmpty();
    }

    private boolean verificarNombreFiguritaRepetido(String nombre) {
        return ((this.repoFigurita.buscarFiguritaPorNombre(nombre)) != null);
    }

    @Override
    public Figurita buscarFiguritaNombreEquipo(String nombre, String equipo) {
        repoFigurita.findByNombreAndEquipo(nombre, equipo);
        return null;
    }

    @Override
    public List<Figurita> buscarFiguritaPorNombre(String nombre) {

        return repoFigurita.findByNombre(nombre);
    }

    @Override
    public List<Figurita> buscarFiguritasPorEquipo(Integer idEquipo) {
        repoFigurita.findAllByIdEquipo(idEquipo);
        return null;
    }

    @Override
    public List<Posicion> traerPosiciones() {
        return this.repoFigurita.getPosiciones();
    }

    @Override
    public List<Rareza> traerRarezas() {
        return this.repoFigurita.getRarezas();
    }

    @Override
    public List<Figurita> traerFiguritas() {
        List<Figurita> figuritas = repoFigurita.getFiguritas();
        return figuritas;
    }

    @Override
    public Figurita buscarFigurita(Long id) {
        return repoFigurita.buscarFiguritaPorID(id);
    }

    @Override
    public List<Figurita> buscarFiguritaPorFiltros(String nombre, Long  seleccion, Long posicion) {
        /*Cambios*/

        List<Figurita> figuritasEncontradas = new ArrayList<>();

        Boolean buscarNombre = (nombre != null && nombre != "");
        Boolean buscarSeleccion = (seleccion != null && seleccion != 0);
        Boolean buscarPosicion = (posicion != null && posicion != 0);

        if(buscarNombre){
            figuritasEncontradas = repoFigurita.findByNombre(nombre);
        }
        if(buscarSeleccion){
            List<Figurita> figsPorSeleccion = repoFigurita.findBySeleccion(seleccion);
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
            List<Figurita> figsPorPosicion = repoFigurita.findByPosicion(posicion);

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

        /********/
    }

    @Override
    public void editarFigurita(long figuritaId, String figuritaNueva) {
        this.repoFigurita.editarFigurita(figuritaId, figuritaNueva);
    }

    @Override
    public void eliminarFigurita(Long figuritaId) {

        Long zero= 0L;
        if(figuritaId == zero){
            throw new FiguritaExceptionGeneral();
        }

        this.repoFigurita.eliminarFigurita(figuritaId);

    }
}
