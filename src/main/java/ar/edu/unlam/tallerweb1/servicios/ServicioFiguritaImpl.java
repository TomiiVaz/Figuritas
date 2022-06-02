package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.Posicion;
import ar.edu.unlam.tallerweb1.modelo.Rareza;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFigurita;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioFigurita")
@Transactional
public class ServicioFiguritaImpl implements ServicioFigurita{

    private RepositorioFigurita repoFigurita;

    @Autowired
    public ServicioFiguritaImpl(RepositorioFigurita repoFigurita){
        this.repoFigurita = repoFigurita;
    }


    @Override
    public void agregarFigurita(Figurita figurita) {
        repoFigurita.guardar(figurita);

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
        return repoFigurita.encontrarFigurita(id);
    }

    @Override
    public List<Figurita> buscarFiguritaPorFiltros(String nombre, Long  seleccion, Long posicion) {
        List<Figurita> figuritas = repoFigurita.buscarFiguritaPorFiltros(nombre, seleccion, posicion);
        return figuritas;
    }

    @Override
    public void editarFigurita(long figuritaId, String figuritaNueva) {
        this.repoFigurita.editarFigurita(figuritaId, figuritaNueva);
    }

    @Override
    public void eliminarFigurita(long figuritaId) {

        this.repoFigurita.eliminarFigurita(figuritaId);

    }
}
