package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.RegistroIntercambio;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroIntercambio;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioRegistroIntercambio")
@Transactional
public class ServicioRegistroIntercambioImpl implements ServicioRegistroIntercambio{

    private final RepositorioRegistroIntercambio repoInter;

    @Autowired
    public ServicioRegistroIntercambioImpl(RepositorioRegistroIntercambio repoInter) {
        this.repoInter = repoInter;
    }

    @Override
    public void guardarRegistro(RegistroIntercambio ri) {
        repoInter.guardar(ri);
    }
}
