package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class RegistroIntercambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RegistroPegada registroSolicitante;

    @ManyToOne
    private RegistroPegada registroSolicitado;

    @ManyToOne
    private Estado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RegistroPegada getRegistroSolicitante() {
        return registroSolicitante;
    }

    public void setRegistroSolicitante(RegistroPegada registroSolicitante) {
        this.registroSolicitante = registroSolicitante;
    }

    public RegistroPegada getRegistroSolicitado() {
        return registroSolicitado;
    }

    public void setRegistroSolicitado(RegistroPegada registroSolicitado) {
        this.registroSolicitado = registroSolicitado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
