package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.RegistroPegada;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.*;

public interface RepositorioRegistroPegada {

    void pegar(RegistroPegada rp);
    void update(RegistroPegada rp);
    List<RegistroPegada> traerFiguritasPegadasPorUsuario(Long idUsuario);

    List<RegistroPegada> traerFiguritasIntercambiables(Usuario usuario);

    List<RegistroPegada> traerFiguritasIntercambiables();

    RegistroPegada getRegistroPorId(Long id);

    List<RegistroPegada> getRegistroPorNombreFigurita(String nombre);

    List<RegistroPegada> getRegistroPorSeleccionFigurita(Long seleccion);

    List<RegistroPegada> getRegistroPorAlbumFigurita(Long album, Long usuario);

    List<RegistroPegada> getRegistroPorPosicionFigurita(Long posicion);

    List<RegistroPegada> getRegistroPorSeleccionFiguritaUsuario(Long seleccion, Long idUsuario);

    List<RegistroPegada> getRegistroPorSeleccionAlbumUsuario(Long seleccion, Long album, Long idUsuario);
}
