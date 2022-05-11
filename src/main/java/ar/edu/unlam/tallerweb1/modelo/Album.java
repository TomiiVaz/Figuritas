package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.*;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<Figurita> listaDeFiguritas;

    public Integer getId() {
        return id;
    }


    public List<Figurita> getListaDeFiguritas() {
        return listaDeFiguritas;
    }

    public void setListaDeFiguritas(List<Figurita> listaDeFiguritas) {
        this.listaDeFiguritas = listaDeFiguritas;
    }
}
