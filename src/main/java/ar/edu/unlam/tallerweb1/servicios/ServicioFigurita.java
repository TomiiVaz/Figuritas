package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.Posicion;
import ar.edu.unlam.tallerweb1.modelo.Rareza;

import java.util.*;

public interface ServicioFigurita {


    void agregarFigurita(Figurita figurita);
    Figurita buscarFiguritaNombreEquipo(String nombre, String equipo);
    Figurita buscarFiguritaPorNombre(String nombre);
    List<Figurita> buscarFiguritasPorEquipo(Integer idEquipo);

    List<Posicion> traerPosiciones();

    List<Rareza> traerRarezas();
}
