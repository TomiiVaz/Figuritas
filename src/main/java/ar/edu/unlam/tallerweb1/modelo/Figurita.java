package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Figurita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    private byte dorsal;

    private String equipo;

    private int anio;

    @ManyToOne
    private Posicion posicion;

    @ManyToOne
    private Rareza rareza;

    @ManyToOne
    private Seleccion seleccion;

    @ManyToOne
    private Album album;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getAño() {
        return anio;
    }

    public void setAño(int anio) {
        this.anio = anio;
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
