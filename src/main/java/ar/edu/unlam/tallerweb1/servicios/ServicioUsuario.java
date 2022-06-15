package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioUsuario {

	Usuario consultarUsuario(String email, String password);

    void registrarUsuario(Usuario usuario);

    Boolean verificarMail(String mail);

    Usuario agarrarUsuarioId(Long id);

//    void modificarDatosUsuario(Long id, String email, String email1, Seleccion seleccion);

    void modificarDatosUsuario(Usuario usuario);
}
