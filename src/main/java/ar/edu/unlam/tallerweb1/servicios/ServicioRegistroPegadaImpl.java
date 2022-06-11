package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.modelo.RegistroPegada;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistroPegada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("servicioRegistroPegada")
@Transactional
public class ServicioRegistroPegadaImpl implements ServicioRegistroPegada{

    private RepositorioRegistroPegada repositorioRp;

    @Autowired
    public ServicioRegistroPegadaImpl(RepositorioRegistroPegada repositorioRp) {
        this.repositorioRp = repositorioRp;
    }

    @Override
    public void pegarRegistro(RegistroPegada rp) {
        repositorioRp.pegar(rp);
    }

    @Override
    public List<RegistroPegada> getPegadasUsuario(Long idUsuario) {
        return repositorioRp.traerFiguritasPegadasPorUsuario(idUsuario);
    }


}
