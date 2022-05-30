package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Album;

import java.util.*;

public interface ServicioAlbum {

    void agregarAlbum(Album album);

    List<Album> traerAlbunes();

    void editarAlbum(Long albumId, String nombreNuevo);

    void eliminarAlbum(long albumId);
}
