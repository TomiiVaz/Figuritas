package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Seleccion;

import java.util.*;

public interface ServicioSeleccion {

    void crearSeleccion(Seleccion seleccion);
    List<Seleccion> traerSelecciones();

    void editarSeleccion(Long id, String nombreNuevo);

    public void eliminarSeleccion(Long id);

    public Seleccion getSeleccionPorId(Long id);
}
