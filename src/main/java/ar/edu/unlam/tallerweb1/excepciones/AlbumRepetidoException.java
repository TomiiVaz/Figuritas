package ar.edu.unlam.tallerweb1.excepciones;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class AlbumRepetidoException extends RuntimeException {
    public AlbumRepetidoException(String mensaje) {
        super(mensaje);
    }
}
