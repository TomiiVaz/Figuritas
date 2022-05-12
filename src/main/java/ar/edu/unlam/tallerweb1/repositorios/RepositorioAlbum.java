package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;

import java.util.*;

public interface RepositorioAlbum {
    void agregarFigurita(Figurita figu);
    Figurita getFigurita(Integer codigo);
    List<Figurita> findAllByNombre(String nombre);
    List<Figurita> findAllByEquipo(Integer idEquipo);
}
