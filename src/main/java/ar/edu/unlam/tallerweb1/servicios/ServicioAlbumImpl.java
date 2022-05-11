package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Figurita;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioAlbum")
@Transactional
public class ServicioAlbumImpl implements ServicioAlbum{

   private RepositorioAlbum repoAlbum;

   @Autowired
   private ServicioAlbumImpl(RepositorioAlbum repoAlbum){
       this.repoAlbum=repoAlbum;
   }

    @Override
    public void pegarFigurita(Figurita figu) {
        repoAlbum.agregarFigurita(figu);
    }
}
