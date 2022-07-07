package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Album;


import java.util.*;

public interface RepositorioAlbum {

    void guardar(Album album);

    List<Album> traerAlbunes();

    void editarAlbum(Long albumId, String nombreNuevo);

    void eliminarAlbum(long albumId);

    Album getAlbum(Long id);

    Album getAlbum(String nombre);
}
