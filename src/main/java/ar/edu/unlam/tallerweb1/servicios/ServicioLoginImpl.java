package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.excepciones.ContraseñasDistintasException;
import ar.edu.unlam.tallerweb1.excepciones.LongitudIncorrectaException;
import ar.edu.unlam.tallerweb1.excepciones.UsuarioMailExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin {

    private final RepositorioUsuario repoUsuaio;

    @Autowired
    public ServicioLoginImpl(RepositorioUsuario servicioLoginDao) {
        this.repoUsuaio = servicioLoginDao;
    }

    @Override
    public Usuario consultarUsuario(String email, String password) {
        return repoUsuaio.buscarUsuario(email, password);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        if(verificarMail(usuario.getEmail())){
            throw new UsuarioMailExistenteException();
        }
        if(!verificarIguales(usuario.getPassword(), usuario.getPassword2())){
            throw new ContraseñasDistintasException();
        }
        if(!verificarLongitud(usuario.getPassword())){
            throw new LongitudIncorrectaException();
        }
        repoUsuaio.guardar(usuario);
    }

    private Boolean verificarLongitud(String password) {
        return password.length()>=8;
    }

    private Boolean verificarIguales(String password, String password2) {
        return password.equals(password2);
    }

    @Override
    public Boolean verificarMail(String mail) {
        return this.repoUsuaio.getUsuario(mail) != null;
    }

    @Override
    public Usuario agarrarUsuarioId(Long id) {
        return repoUsuaio.getUsuario(id);
    }

}
