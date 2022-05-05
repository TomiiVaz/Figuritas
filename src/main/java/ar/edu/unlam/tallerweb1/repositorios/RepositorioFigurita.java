package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;

public interface RepositorioFigurita {

    void guardar(Integer codigo);
    Figurita findByNombreAndEquipo(String nombre, String equipo);
}
