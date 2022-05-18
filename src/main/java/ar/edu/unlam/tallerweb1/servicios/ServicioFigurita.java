package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;

import java.util.*;

public interface ServicioFigurita {


    void agregarFigurita(Figurita figurita);
    Figurita buscarFiguritaNombreEquipo(String nombre, String equipo);
    Figurita buscarFiguritaPorNombre(String nombre);
    List<Figurita> buscarFiguritasPorEquipo(Integer idEquipo);
}
