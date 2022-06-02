package ar.edu.unlam.tallerweb1.excepciones;

public class UsuarioMailExistenteException extends RuntimeException {
    public UsuarioMailExistenteException(String mensaje) {
        super(mensaje);
    }
}
