package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.RegistroPegada;

import java.util.List;

public interface ServicioRegistroPegada {
    void pegarRegistro(RegistroPegada rp);
    List<RegistroPegada> getPegadasUsuario(Long idUsuario);

    RegistroPegada buscarRegistroId(Long id);
}
