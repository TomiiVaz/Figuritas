package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.excepciones.SeleccionAlbumNullException;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioSeleccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        if(seleccion.getAlbum().getId() == 0){
            throw new SeleccionAlbumNullException();
        }
        this.repoSelec.guardar(seleccion);
    }

    @Override
    public List<Seleccion> traerSelecciones() {
        List<Seleccion> selecciones = repoSelec.getSelecciones();
        return selecciones;
    }

    @Override
    public void editarSeleccion(Long id, String nombreNuevo){
        this.repoSelec.editarSeleccion(id, nombreNuevo);
    }

    @Override
    public void eliminarSeleccion(Long id){
        this.repoSelec.eliminarSeleccion(id);
    }
}
