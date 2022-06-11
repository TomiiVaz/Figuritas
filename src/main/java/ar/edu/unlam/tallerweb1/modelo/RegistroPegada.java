package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class RegistroPegada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Figurita figurita;

    @ManyToOne
    private Album album;

    @ManyToOne
    private Usuario usuario;

    private Boolean intercambiable;

    public Boolean getIntercambiable() {
        return intercambiable;
    }

    public void setIntercambiable(Boolean intercambiable) {
        this.intercambiable = intercambiable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Figurita getFigurita() {
        return figurita;
    }

    public void setFigurita(Figurita figurita) {
        this.figurita = figurita;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
