package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.excepciones.*;
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

        if( seleccion.getAlbum().getId() == 0 && (seleccion.getNombre() == null || seleccion.getNombre().length() == 0) ){
            throw new SeleccionCamposVacíosException();
        }
        if(seleccion.getAlbum().getId() == 0){
            throw new SeleccionAlbumNullException();
        }
        if(seleccion.getNombre() == null || seleccion.getNombre().length() == 0){
            throw new SeleccionNombreVacioException();
        }

        String nombreSel = seleccion.getNombre();
        if(! isAlfabetico(nombreSel)){
            throw new SeleccionNombreTieneNumerosOCaracteresEspecialesException();
        }


        this.repoSelec.guardar(seleccion);
    }

    private Boolean isAlfabetico(String cadena){
        Boolean resultado = true;
        char[] nombreSelArray = cadena.toCharArray();
        for (char c: nombreSelArray) {
            if(! Character.isAlphabetic(c)){
                resultado = false;
                break;
            }
        }
        return resultado;
    }

    @Override
    public List<Seleccion> traerSelecciones() {
        List<Seleccion> selecciones = repoSelec.getSelecciones();
        return selecciones;
    }

    @Override
    public void editarSeleccion(Long id, String nombreNuevo){
        if(id == null || id == 0){
            throw new SeleccionSelectorNoUsado();
        }
        if(nombreNuevo == null || nombreNuevo == ""){
            throw new SeleccionNombreVacioException();
        }
        if(! repoSelec.getSeleccionesPorNombre(nombreNuevo).isEmpty()){
            throw new SeleccionNombreEnUsoException();
        }
        if(! isAlfabetico(nombreNuevo)){
            throw new SeleccionNombreTieneNumerosOCaracteresEspecialesException();
        }

        this.repoSelec.editarSeleccion(id, nombreNuevo);
    }

    @Override
    public void eliminarSeleccion(Long id){
        if(id == 0 || id==null){
            throw new SeleccionSelectorNoUsado();
        }

        this.repoSelec.eliminarSeleccion(id);
    }

    @Override
    public Seleccion getSeleccionPorId(Long id){
        return repoSelec.getSeleccionPorId(id);
    }
}
