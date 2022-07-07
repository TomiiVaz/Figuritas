package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioUsuario {

	Usuario consultarUsuario(String email, String password);

    void registrarUsuario(Usuario usuario);

    Boolean verificarMail(String mail);

    Usuario getUsuario(Long id);

    void modificarDatosUsuario(Usuario usuario);


    List<Usuario> getUsuarios();

    void eliminarUsuario(Usuario usuario);

}
