package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.Posicion;
import ar.edu.unlam.tallerweb1.modelo.Rareza;

import java.util.*;

public interface RepositorioFigurita {

    void guardar(Figurita figurita);
    Figurita findByNombreAndEquipo(String nombre, String equipo);
    List<Figurita> findByNombre(String nombre);
    List<Figurita> findAllByIdEquipo(Integer idEquipo);
    List<Posicion> getPosiciones();
    List<Rareza> getRarezas();

    List<Figurita> getFiguritas();

    List<Figurita> buscarFiguritaPorFiltros(String nombre, Long seleccion, Long posicion);

    void editarFigurita(long figuritaId, String figuritaNueva);

    void eliminarFigurita(long figuritaId);

    Figurita encontrarFigurita(Long id);
}
