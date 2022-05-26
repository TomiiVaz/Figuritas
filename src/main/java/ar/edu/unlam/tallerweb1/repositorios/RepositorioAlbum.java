package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Figurita;

import java.util.*;

public interface RepositorioAlbum {

    void guardar(Album album);

    List<Album> traerAlbunes();
}
