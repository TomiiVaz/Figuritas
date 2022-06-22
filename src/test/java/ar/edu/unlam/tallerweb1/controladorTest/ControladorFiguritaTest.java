package ar.edu.unlam.tallerweb1.controladorTest;

import ar.edu.unlam.tallerweb1.controladores.ControladorFigurita;
import ar.edu.unlam.tallerweb1.excepciones.FiguritaConConEquipoVacioExcepition;
import ar.edu.unlam.tallerweb1.excepciones.FiguritaConNombreRepetidoException;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ControladorFiguritaTest {

    private final ServicioFigurita servicioFigurita = mock(ServicioFigurita.class);
    private final ServicioSeleccion servicioSeleccion = mock(ServicioSeleccion.class);
    private final ServicioAlbum servicioAlbum = mock(ServicioAlbum.class);
    private final ServicioUsuario servicioUsuario = mock(ServicioUsuario.class);
    private final ServicioRegistroPegada servicioRegistroPegada = mock(ServicioRegistroPegada.class);
    private final ServicioComentario servicioComentario = mock(ServicioComentario.class);
    private final ControladorFigurita controladorFigurita = new ControladorFigurita(servicioFigurita, servicioSeleccion, servicioAlbum, servicioUsuario, servicioRegistroPegada, servicioComentario);


    private ModelAndView mav = new ModelAndView();

    private final HttpServletRequest mockRequest = mock(HttpServletRequest.class);
    private final HttpSession mockSession = mock(HttpSession.class);

    @Test
    public void queSePuedaCrearUnaFiguritaCorrectamente(){

        // Preparacion -> given
        Figurita figurita = new Figurita();

        // Ejecucion -> when

        whenSeCreaUnaFigurita(figurita);

        // Comprobacion -> then
        thenQueLaVistaSeaRedirect();

    }

    @Test
    public void queElControladorLanceLaFiguritaConNombreRepetidoException(){

        // Preparacion -> given
        Figurita figurita = new Figurita();

        // Ejecucion -> when
        doThrow(FiguritaConNombreRepetidoException.class)
                .when(servicioFigurita)
                        .agregarFigurita(figurita);

        whenSeCreaUnaFigurita(figurita);

        // Comprobacion -> then
        thenQueTireElmensajeDeFiguritaConNombreRepetidoException();

    }

    @Test
    public void queElControladorLanceLaFiguritaConEquipoVacioExcepition(){

        // Preparacion -> given
        Figurita figurita = new Figurita();

        // Ejecucion -> when
        doThrow(FiguritaConConEquipoVacioExcepition.class)
                .when(servicioFigurita)
                .agregarFigurita(figurita);

        whenSeCreaUnaFigurita(figurita);

        // Comprobacion -> then
        thenQueTireElmensajeDeFiguritaConEquipoVacioExcepition();

    }


    private void whenSeCreaUnaFigurita(Figurita figurita) {
        definirComportamientoMocksSession();


        mav = this.controladorFigurita.crearFigurita(figurita, mockRequest);
    }

    private void definirComportamientoMocksSession() {
        when(mockRequest.getSession()).thenReturn(mockSession);
        when(mockRequest.getSession().getAttribute("ROL")).thenReturn("ADM");
        when(mockRequest.getSession().getAttribute("ID")).thenReturn(1L);
        when(mockRequest.getSession().getAttribute("USUARIO")).thenReturn(new Usuario());
    }

    private void thenQueLaVistaSeaRedirect() {
        assertThat(mav.getViewName()).isEqualTo("redirect:/configuracion-figurita");
    }

    private void thenQueTireElmensajeDeFiguritaConNombreRepetidoException() {
        assertThat(mav.getModel().get("NombreFiguritaRepetido")).isEqualTo("El nombre de la figurita ya existe");
    }

    private void thenQueTireElmensajeDeFiguritaConEquipoVacioExcepition() {
        assertThat(mav.getViewName()).isEqualTo("configFigurita");
    }


    @Test
    public void queSePuedaBuscarFiguritaPorNombre(){
        // Preparacion -> given
        String nombreCargado = "Messi";

        // Ejecucion -> when
        whenSeBuscaUnaFiguritaPorNombre(nombreCargado);
        // Comprobacion -> then
        thenQueLaVistaSeaBuscarFigsConResDeBusqueda(nombreCargado);

    }

    private void whenSeBuscaUnaFiguritaPorNombre(String nombreCargado) {
        definirComportamientoMocksSession();

        Long idUsuario = ( Long ) ( mockRequest.getSession().getAttribute("ID") );

        when( servicioSeleccion.traerSelecciones() ).thenReturn( new ArrayList<Seleccion>() );
        when( servicioFigurita.traerPosiciones() ).thenReturn( new ArrayList<Posicion>() );
        when( servicioRegistroPegada.getIntercambiablesPorFiltros(nombreCargado,0l,0l, idUsuario) ).thenReturn( new ArrayList<RegistroPegada>() );

        mav = this.controladorFigurita.buscarFiguritas(nombreCargado,0l,0l,mockRequest);
    }
    private void thenQueLaVistaSeaBuscarFigsConResDeBusqueda(String nombreCargado) {
        assertThat( mav.getViewName() ).isEqualTo( "buscarFiguritas");
    }

}
