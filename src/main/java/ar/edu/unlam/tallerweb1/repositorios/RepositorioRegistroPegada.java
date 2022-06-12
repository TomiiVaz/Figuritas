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

}
