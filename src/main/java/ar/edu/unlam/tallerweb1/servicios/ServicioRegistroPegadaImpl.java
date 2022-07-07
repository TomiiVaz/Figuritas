package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.excepciones.CodigoIncorrectoExcepcion;
import ar.edu.unlam.tallerweb1.excepciones.FiguritaAlbumSinCoincidenciaException;
import ar.edu.unlam.tallerweb1.excepciones.NoSeEncontraronFiguritasException;
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

        if(rp.getFigurita()==null) {
            throw new CodigoIncorrectoExcepcion();
        }

        if(!rp.getFigurita().getAlbum().getNombre().equals(rp.getAlbum().getNombre())){
            throw new FiguritaAlbumSinCoincidenciaException();
        }

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
    public List<RegistroPegada> getIntercambiablesPorFiltros(String nombreIngresado, Long seleccionIngresada, Long posicionIngresada, Long idUsuario) {
        List<RegistroPegada> registrosEncontrados = new ArrayList<>();
        if(idUsuario == 0l){
            registrosEncontrados = repositorioRp.traerFiguritasIntercambiables();
        }else{
            registrosEncontrados = repositorioRp.traerFiguritasIntercambiablesParaBusqueda(idUsuario);
        }


        Boolean seBuscaNombre = (nombreIngresado != null && nombreIngresado != "");
        Boolean seBuscaSeleccion = (seleccionIngresada != null && seleccionIngresada != 0);
        Boolean seBuscaPosicion = (posicionIngresada != null && posicionIngresada != 0);


        if(seBuscaNombre){
            List<RegistroPegada> regsPorNombreIngresado = repositorioRp.getRegistroPorNombreFigurita(nombreIngresado);
            
            hacerDiferenciaDeListas(registrosEncontrados,regsPorNombreIngresado);
        }

        if(seBuscaSeleccion){
            List<RegistroPegada> regsPorSeleccionIngresada = repositorioRp.getRegistroPorSeleccionFigurita(seleccionIngresada);

            hacerDiferenciaDeListas(registrosEncontrados,regsPorSeleccionIngresada);
        }

        if(seBuscaPosicion){
            List<RegistroPegada> regsPorPosicionIngresada = repositorioRp.getRegistroPorPosicionFigurita(posicionIngresada);

            hacerDiferenciaDeListas(registrosEncontrados,regsPorPosicionIngresada);
        }

        if(registrosEncontrados.size() == 0) throw new NoSeEncontraronFiguritasException();

        return registrosEncontrados;

        /********/
    }

    @Override
    public List<RegistroPegada> getIntercambiablesPerfil(Long seleccion, Long album, Long idUsuario) {

        List<RegistroPegada> busqueda = new ArrayList<>();
        Long cero = 0l;

        if(seleccion!=cero){
            busqueda.addAll(repositorioRp.getRegistroPorSeleccionFiguritaUsuario(seleccion, idUsuario));
        }

        if(album!=cero){
            busqueda.addAll( repositorioRp.getRegistroPorAlbumFigurita(album,idUsuario) );
        }

        if(seleccion!=cero && album!=cero){
            busqueda.clear();
            busqueda.addAll(repositorioRp.getRegistroPorSeleccionAlbumUsuario(seleccion, album, idUsuario));
        }

        if(seleccion==cero && album==cero){
            busqueda.clear();
            busqueda.addAll(repositorioRp.traerFiguritasPegadasPorUsuario(idUsuario));
        }

        return busqueda;
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
