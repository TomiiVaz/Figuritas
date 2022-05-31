package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Usuario consultarUsuario(String email, String password);

    void registrarUsuario(Usuario usuario);

    Boolean verificarMail(String mail);

    Usuario agarrarUsuarioId(Long id);
}
