package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Comentario;
import ar.edu.unlam.tallerweb1.modelo.Figurita;

import java.util.List;


public interface RepositorioComentario {

    void guardar(Comentario comentario);

    List<Comentario> getComentarios();
}
