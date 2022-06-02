package ar.edu.unlam.tallerweb1.excepciones;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class AlbumRepetidoException extends Exception {
    public AlbumRepetidoException(String mensaje) {
        super(mensaje);
    }
}
