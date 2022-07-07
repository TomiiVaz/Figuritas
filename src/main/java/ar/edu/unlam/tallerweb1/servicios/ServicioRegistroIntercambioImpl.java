package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.excepciones.FiguritaAlbumSinCoincidenciaException;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.RegistroIntercambio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroIntercambio;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroPegada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioRegistroIntercambio")
@Transactional
public class ServicioRegistroIntercambioImpl implements ServicioRegistroIntercambio{

    private final RepositorioRegistroIntercambio repoInter;
    private final RepositorioRegistroPegada repoPegada;

    @Autowired
    public ServicioRegistroIntercambioImpl(RepositorioRegistroIntercambio repoInter, RepositorioRegistroPegada repoPegada) {
        this.repoInter = repoInter;
        this.repoPegada = repoPegada;
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

    @Override
    public List<RegistroIntercambio> getIntercambiosQueMePiden(Long idUser) {
        return repoInter.traerIntercambiosQueMeHacen(idUser);
    }

    @Override
    public List<RegistroIntercambio> getIntercambiosQueHago(Long idUser) {
        return repoInter.traerIntercambiosQueHago(idUser);
    }

    @Override
    public RegistroIntercambio traerRegistroIntercambioId(Long id) {
        return repoInter.getRegistroIntercambioId(id);
    }

    @Override
    public void aceptarIntercambio(Long id) {
        RegistroIntercambio ri = repoInter.getRegistroIntercambioId(id);
        Estado estado = repoInter.getEstadoId(2l);
        ri.setEstado(estado);
        Usuario u1 = ri.getRegistroPide().getUsuario();
        Usuario u2 = ri.getRegistroDecide().getUsuario();
        ri.getRegistroDecide().setUsuario(u1);
        ri.getRegistroPide().setUsuario(u2);
        ri.getRegistroDecide().setIntercambiable(false);
        ri.getRegistroPide().setIntercambiable(false);
        repoInter.update(ri);
    }

    @Override
    public void rechazarIntercambio(Long id) {
        RegistroIntercambio ri = repoInter.getRegistroIntercambioId(id);
        Estado estado = repoInter.getEstadoId(3l);
        ri.setEstado(estado);
        repoInter.update(ri);
    }
}
