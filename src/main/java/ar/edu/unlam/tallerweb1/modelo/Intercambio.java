package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Intercambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*
    * usuario1 usuario2
    * figsUsuario1[] figsUsuario2[]
    *
    * */
    @ManyToOne
    private Usuario usuario1;

    @ManyToOne
    private Usuario usuario2;

    @OneToOne
    private Figurita figuritaUsuario1;

    @OneToOne
    private Figurita figuritaUsuario2;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

    public Figurita getFiguritaUsuario1() {
        return figuritaUsuario1;
    }

    public void setFiguritaUsuario1(Figurita figuritaUsuario1) {
        this.figuritaUsuario1 = figuritaUsuario1;
    }

    public Figurita getFiguritaUsuario2() {
        return figuritaUsuario2;
    }

    public void setFiguritaUsuario2(Figurita figuritaUsuario2) {
        this.figuritaUsuario2 = figuritaUsuario2;
    }
}
