package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.RegistroIntercambio;

public interface RepositorioRegistroIntercambio {

    void guardar(RegistroIntercambio ri);
    Estado getEstadoId(Long id);
}
