package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service("servicioSession")
@Transactional
public class ServicioSessionImpl implements ServicioSession{


    @Override
    public String getRol(HttpServletRequest request) {
        return (String)request.getSession().getAttribute("ROL");
    }

    @Override
    public Long getId(HttpServletRequest request) {
        return (Long)request.getSession().getAttribute("ID");
    }

    @Override
    public Usuario getUser(HttpServletRequest request) {
        return (Usuario)request.getSession().getAttribute("USUARIO");
    }
}
