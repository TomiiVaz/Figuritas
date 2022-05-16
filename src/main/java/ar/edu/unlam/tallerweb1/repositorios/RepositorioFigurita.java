package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;

import java.util.*;

public interface RepositorioFigurita {

    void guardar(Integer codigo);
    Figurita findByNombreAndEquipo(String nombre, String equipo);
    Figurita findByNombre(String nombre);
    List<Figurita> findAllByIdEquipo(Integer idEquipo);
}
