package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;

public interface ServicioFigurita {

    void agregarFigurita(Integer codigo);
    Figurita buscarFigurita(String nombre, String equipo);
}
