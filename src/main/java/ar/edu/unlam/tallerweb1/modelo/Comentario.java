package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    @OneToOne
    private RegistroPegada registroPegada;

    @OneToOne
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public RegistroPegada getRegistroPegada() {
        return registroPegada;
    }

    public void setRegistroPegada(RegistroPegada registroPegada) {
        this.registroPegada = registroPegada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
