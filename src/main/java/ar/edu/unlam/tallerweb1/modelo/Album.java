package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.*;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<Figurita> figuritas;

    @OneToMany
    private List<Seleccion> selecciones;

    public Integer getId() {
        return id;
    }


}
