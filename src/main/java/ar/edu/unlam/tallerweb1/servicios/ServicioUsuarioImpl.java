package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.excepciones.ContraseñasDistintasException;
import ar.edu.unlam.tallerweb1.excepciones.LongitudIncorrectaException;
import ar.edu.unlam.tallerweb1.excepciones.UsuarioMailExistenteException;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

    private final RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario servicioLoginDao) {
        this.repositorioUsuario = servicioLoginDao;
    }

    @Override
    public Usuario consultarUsuario(String email, String password) {
        return repositorioUsuario.buscarUsuario(email, password);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        if (verificarMail(usuario.getEmail())) {
            throw new UsuarioMailExistenteException();
        }
        if (!verificarIguales(usuario.getPassword(), usuario.getPassword2())) {
            throw new ContraseñasDistintasException();
        }
        if (!verificarLongitud(usuario.getPassword())) {
            throw new LongitudIncorrectaException();
        }
        repositorioUsuario.guardar(usuario);
    }

    private Boolean verificarLongitud(String password) {
        return password.length() >= 8;
    }

    private Boolean verificarIguales(String password, String password2) {
        return password.equals(password2);
    }

    @Override
    public Boolean verificarMail(String mail) {
        return this.repositorioUsuario.getUsuario(mail) != null;
    }

    @Override
    public Usuario getUsuario(Long id) {
        return repositorioUsuario.getUsuario(id);
    }

    @Override
    public void modificarDatosUsuario(Usuario usuario) {
        this.repositorioUsuario.modificarUsuario(usuario);
    }

    @Override
    public List<Usuario> getUsuarios() {
        return repositorioUsuario.traerUsuarios();
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        repositorioUsuario.delete(usuario);
    }

    @Override
    public void mandarMailDeRegistracion(String mail, String nombre) {
        String to = mail;

        //provide sender's email ID
        String from = "gauchorocket30@gmail.com";
        //provide Mailtrap's username
        final String username = "gauchorocket30";
        //provide Mailtrap's password
        final String password = "tnfeghestzihwnnp";

        //provide Mailtrap's host address
        String host = "smtp.gmail.com";
        //configure Mailtrap's SMTP server details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        //create the Session object
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            //create a MimeMessage object
            Message message = new MimeMessage(session);

            //set From email field
            message.setFrom(new InternetAddress(from));

            //set To email field
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            //set email subject field
            message.setSubject("Figus!");

            //set the content of the email message
            message.setText("Gracias " + nombre + " por registrarte en Figus");

            //send the email message
            Transport.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
