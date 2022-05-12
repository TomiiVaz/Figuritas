package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;

import java.util.*;

public interface ServicioAlbum {

    void pegarFigurita(Figurita figu);
    Figurita buscarFiguritaPorCodigo(Integer codigo);
    List<Figurita> buscarFigusPorNombre(String nomrbe);
    List<Figurita> buscarFigusPorEquipo(Integer idEquipo);
}
