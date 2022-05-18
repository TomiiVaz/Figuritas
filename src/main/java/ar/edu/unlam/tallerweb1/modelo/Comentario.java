package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;

    @OneToOne
    private Figurita figurita;

    @OneToOne
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Figurita getFigurita() {
        return figurita;
    }

    public void setFigurita(Figurita figurita) {
        this.figurita = figurita;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
