package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.RegistroPegada;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroPegada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("servicioRegistroPegada")
@Transactional
public class ServicioRegistroPegadaImpl implements ServicioRegistroPegada{

    private RepositorioRegistroPegada repositorioRp;

    @Autowired
    public ServicioRegistroPegadaImpl(RepositorioRegistroPegada repositorioRp) {
        this.repositorioRp = repositorioRp;
    }

    @Override
    public void pegarRegistro(RegistroPegada rp) {

        if(rp.getId()!=null){
            repositorioRp.update(rp);
        } else{
            repositorioRp.pegar(rp);
        }
    }

    @Override
    public List<RegistroPegada> getPegadasUsuario(Long idUsuario) {
        return repositorioRp.traerFiguritasPegadasPorUsuario(idUsuario);
    }

    @Override
    public List<RegistroPegada> getIntercambiables(Usuario usuario) {
        if(usuario!= null && usuario.getId()!=null){
            return repositorioRp.traerFiguritasIntercambiables(usuario);
        } else {
            return repositorioRp.traerFiguritasIntercambiables();
        }

    }

    @Override
    public RegistroPegada buscarRegistroId(Long id) {
        return repositorioRp.getRegistroPorId(id);
    }

    @Override
    public List<RegistroPegada> getIntercambiablesPorFiltros(String nombre, Long seleccion, Long posicion) {
        List<RegistroPegada> registrosEncontrados = new ArrayList<>();
        registrosEncontrados = repositorioRp.traerFiguritasIntercambiables();


        Boolean buscarNombre = (nombre != null && nombre != "");
        Boolean buscarSeleccion = (seleccion != null && seleccion != 0);
        Boolean buscarPosicion = (posicion != null && posicion != 0);

        if(buscarNombre){
            List<RegistroPegada> regsPorNombre = repositorioRp.getRegistroPorNombreFigurita(nombre);
            
            hacerDiferenciaDeListas(registrosEncontrados,regsPorNombre);
        }

        if(buscarSeleccion){
            List<RegistroPegada> regsPorSeleccion = repositorioRp.getRegistroPorSeleccionFigurita(seleccion);

            hacerDiferenciaDeListas(registrosEncontrados,regsPorSeleccion);
        }

        if(buscarPosicion){
            List<RegistroPegada> regsPorPosicion = repositorioRp.getRegistroPorPosicionFigurita(posicion);

            hacerDiferenciaDeListas(registrosEncontrados,regsPorPosicion);
        }
        return registrosEncontrados;

        /********/
    }

    private List<RegistroPegada> hacerDiferenciaDeListas(List<RegistroPegada> aRetornar, List<RegistroPegada> deComparacion){
        if(aRetornar.size() > 0){
            for (int i = 0; i < aRetornar.size(); i++) {
                if(! deComparacion.contains(aRetornar.get(i)) ){ //si no contiene el elemento, sacalo de la lista
                    aRetornar.remove(i);
                    i--; //al remover los elementos siguientes de la lista restan 1 en su indice, por lo tanto hay q reveer la posicion eliminada
                }
                if(aRetornar.size() <= 0) break;
            }
        }
        else{
            aRetornar = deComparacion;
        }
        return aRetornar;
    }
}
