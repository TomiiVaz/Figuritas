package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("servicioComentario")
@Transactional
public class ServicioComentarioImpl implements ServicioComentario{

    private final RepositorioComentario repoComentario;

    @Autowired
    public ServicioComentarioImpl(RepositorioComentario repoComentario) {
        this.repoComentario = repoComentario;
    }

    @Override
    public void agregarComentario(Comentario comentario) {
        this.repoComentario.guardar(comentario);
    }

    @Override
    public List<Comentario> traerComentarios() {
        return this.repoComentario.getComentarios();
    }

    @Override
    public List<Comentario> traerComentariosPorID(Long id) {
        return this.repoComentario.getComentariosPorId(id);
    }
}
