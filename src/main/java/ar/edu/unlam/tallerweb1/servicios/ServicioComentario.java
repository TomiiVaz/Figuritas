package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.Figurita;

import java.util.List;


public interface ServicioComentario {

    void agregarComentario(Comentario comentario);

    List<Comentario> traerComentarios();

    List<Comentario> traerComentariosPorID(Long id);
}
