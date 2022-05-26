package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Seleccion;

import java.util.*;

public interface RepositorioSeleccion {

    void guardar(Seleccion seleccion);
    List<Seleccion> getSelecciones();

    void editarSeleccion(Long id, String nombreNuevo);
}
