package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.RegistroIntercambio;

import java.util.List;

public interface ServicioRegistroIntercambio {

    void guardarRegistro(RegistroIntercambio ri);
    List<RegistroIntercambio> getIntercambiosQueMePiden(Long idUser);
    List<RegistroIntercambio> getIntercambiosQueHago(Long idUser);

    RegistroIntercambio traerRegistroIntercambioId(Long id);
    void aceptarIntercambio(Long id);
    void rechazarIntercambio(Long id);
}
