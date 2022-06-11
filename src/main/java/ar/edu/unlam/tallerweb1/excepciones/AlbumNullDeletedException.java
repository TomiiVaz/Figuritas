package ar.edu.unlam.tallerweb1.excepciones;

public class AlbumNullDeletedException extends RuntimeException {
    public AlbumNullDeletedException(String mensaje) {
        super(mensaje);
    }
}
