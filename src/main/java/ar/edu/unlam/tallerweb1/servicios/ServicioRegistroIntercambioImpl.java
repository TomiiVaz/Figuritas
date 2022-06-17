package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.excepciones.FiguritaAlbumSinCoincidenciaException;
import ar.edu.unlam.tallerweb1.modelo.Estado;
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

        if(ri.getRegistroPide().getAlbum().getId()!=ri.getRegistroDecide().getAlbum().getId()){
            throw new FiguritaAlbumSinCoincidenciaException();
        }

        Estado estado = repoInter.getEstadoId(1l);
        ri.setEstado(estado);
        repoInter.guardar(ri);
    }
}
