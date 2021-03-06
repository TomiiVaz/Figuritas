package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.Posicion;
import ar.edu.unlam.tallerweb1.modelo.Rareza;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;

import java.util.*;

public interface ServicioFigurita {


    void agregarFigurita(Figurita figurita);

    Posicion getPosicionPorId(Long id);
    Figurita buscarFiguritaNombreEquipo(String nombre, String equipo);
    List<Figurita> buscarFiguritaPorNombre(String nombre);
    List<Figurita> buscarFiguritasPorEquipo(Integer idEquipo);

    List<Posicion> traerPosiciones();

    List<Rareza> traerRarezas();

    List<Figurita> traerFiguritas();

    Figurita buscarFigurita(Long id);

    List<Figurita> buscarFiguritaPorFiltros(String nombre, Long seleccion, Long posicion);

    void editarFigurita(long figuritaId, String figuritaNueva);

    void eliminarFigurita(Long figuritaId);


}
