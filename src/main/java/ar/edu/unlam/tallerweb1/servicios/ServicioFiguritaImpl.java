package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFigurita;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;

public class ServicioFiguritaImpl implements ServicioFigurita{

    private RepositorioFigurita repoFigurita;

    @Autowired
    public ServicioFiguritaImpl(RepositorioFigurita repoFigurita){
        this.repoFigurita = repoFigurita;
    }


    @Override
    public void agregarFigurita(Integer codigo) {
        repoFigurita.guardar(codigo);
    }

    @Override
    public Figurita buscarFigurita(String nombre, String equipo) {
        return null;
    }
}
