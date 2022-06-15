package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.RegistroPegada;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioRegistroPegada {
    void pegarRegistro(RegistroPegada rp);
    List<RegistroPegada> getPegadasUsuario(Long idUsuario);
    List<RegistroPegada> getIntercambiables(Usuario usuario);
    RegistroPegada buscarRegistroId(Long id);

    List<RegistroPegada> getIntercambiablesPorFiltros(String nombre, Long seleccion, Long posicion);
    List<RegistroPegada> getIntercambiablesPerfil(Long seleccion, Long album, Long idUsuario);
}
