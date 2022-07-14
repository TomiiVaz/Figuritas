package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import javax.servlet.http.HttpServletRequest;

public interface ServicioSession {

    String getRol(HttpServletRequest request);

    Long getId(HttpServletRequest request);

    Usuario getUser(HttpServletRequest request);
}
