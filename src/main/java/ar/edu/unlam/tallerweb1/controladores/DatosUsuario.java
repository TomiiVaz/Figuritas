package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import javax.servlet.http.HttpServletRequest;

public class DatosUsuario {

    private Long id;
    private String rol;
    private Usuario usuario;

    public DatosUsuario(HttpServletRequest request){
        this.id= (Long) request.getSession().getAttribute("ID");
        this.rol = (String) request.getSession().getAttribute("ROL");
        this.usuario = (Usuario) request.getSession().getAttribute("USUARIO");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
