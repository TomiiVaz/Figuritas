package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class RegistroIntercambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RegistroPegada registroPide;

    @ManyToOne
    private RegistroPegada registroDecide;

    @ManyToOne
    private Estado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RegistroPegada getRegistroPide() {
        return registroPide;
    }

    public void setRegistroPide(RegistroPegada registroPide) {
        this.registroPide = registroPide;
    }

    public RegistroPegada getRegistroDecide() {
        return registroDecide;
    }

    public void setRegistroDecide(RegistroPegada registroDecide) {
        this.registroDecide = registroDecide;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
