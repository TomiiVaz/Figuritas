package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSeleccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioSeleccion")
@Transactional
public class ServicioSeleccionImpl implements ServicioSeleccion {

    private RepositorioSeleccion repoSelec;

    @Autowired
    private ServicioSeleccionImpl(RepositorioSeleccion repoSelec) {
        this.repoSelec = repoSelec;
    }

    @Override
    public void crearSeleccion(Seleccion seleccion) {

        this.repoSelec.guardar(seleccion);
    }
}
