package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.RegistroIntercambio;

import java.util.List;

public interface RepositorioRegistroIntercambio {

    void guardar(RegistroIntercambio ri);
    Estado getEstadoId(Long id);


    List<RegistroIntercambio> traerIntercambiosQueMeHacen(Long idUser);
    List<RegistroIntercambio> traerIntercambiosQueHago(Long idUser);

}
