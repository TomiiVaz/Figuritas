package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Figurita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    @Enumerated(EnumType.STRING)
    private Posicion posicion;

    private byte dorsal;

    private String equipo;

    private Short año;

    @Enumerated(EnumType.STRING)
    private Rareza rareza;

    @ManyToOne
    private Seleccion seleccion;

    @ManyToOne
    private Album album;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public byte getDorsal() {
        return dorsal;
    }

    public void setDorsal(byte dorsal) {
        this.dorsal = dorsal;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public Short getAño() {
        return año;
    }

    public void setAño(Short año) {
        this.año = año;
    }

    public Rareza getRareza() {
        return rareza;
    }

    public void setRareza(Rareza rareza) {
        this.rareza = rareza;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
