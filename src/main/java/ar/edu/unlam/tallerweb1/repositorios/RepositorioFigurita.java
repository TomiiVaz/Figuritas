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


    void editarFigurita(long figuritaId, String figuritaNueva);

    void eliminarFigurita(long figuritaId);

    Figurita buscarFiguritaPorID(Long id);

    Figurita buscarFiguritaPorNombre(String nombre);

    List<Figurita> findBySeleccion(Long seleccion);
    List<Figurita> findByPosicion(Long posicion);
}
