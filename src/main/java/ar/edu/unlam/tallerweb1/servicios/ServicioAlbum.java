package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Figurita;

import java.util.*;

public interface ServicioAlbum {

    void agregarAlbum(Album album);

    List<Album> traerAlbunes();
}
