package ar.edu.unlam.tallerweb1.controladorTest;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorSeleccion;
import ar.edu.unlam.tallerweb1.excepciones.SeleccionAlbumNullException;
import ar.edu.unlam.tallerweb1.excepciones.SeleccionCamposVacíosException;
import ar.edu.unlam.tallerweb1.excepciones.SeleccionNombreTieneNumerosOCaracteresEspecialesException;
import ar.edu.unlam.tallerweb1.excepciones.SeleccionNombreVacioException;
import ar.edu.unlam.tallerweb1.modelo.Seleccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlbum;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccion;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;


import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ControladorSeleccionTest {

    private final String redirectCorrectoSeleccion = "redirect:/configuracion/seleccion/";
    private final String redirectInorrectoSeleccion = "configSeleccion";
    private final String errorCaracteresNumerosSeleccion = "El nombre no puede contener números ni caracteres especiales";

    private ModelAndView mav = new ModelAndView();

    private ServicioSeleccion servicioSeleccion = mock(ServicioSeleccion.class);
    private ServicioAlbum servicioAlbum = mock(ServicioAlbum.class);
    private ControladorSeleccion controladorSeleccion = new ControladorSeleccion(servicioSeleccion, servicioAlbum);
    
    @Test
    public void queSePuedaAgregarUnaSeleccionTest(){

        //preparacion -> given
        Seleccion seleccion = givenUnaSeleccion();
        //ejecucion -> when

        whenAgregoUnaSeleccion(seleccion);

        //comprobacion -> then
        thenRedirectCorrectoSeleccion();
    }

    private Seleccion givenUnaSeleccion() {
        return new Seleccion();
    }

    private void whenAgregoUnaSeleccion(Seleccion seleccion) {
       mav = controladorSeleccion.crearSeleccion(seleccion);
    }

    private void thenRedirectCorrectoSeleccion() {
        assertThat(mav.getViewName()).isEqualTo(redirectCorrectoSeleccion);
    }

    @Test
    public void queNoSePuedaCrearSeleccionSinNombreTest(){

        //preparacion -> given
        Seleccion seleccion = givenUnaSeleccion();
        //ejecucion -> when

        doThrow(SeleccionNombreVacioException.class)
                .when(servicioSeleccion)
                .crearSeleccion(seleccion);
        
        whenAgregoUnaSeleccion(seleccion);

        //comprobacion -> then
        thenRegistroFalla();

    }

    private void thenRegistroFalla() {
        assertThat(mav.getViewName()).isEqualTo(redirectInorrectoSeleccion);
    }

    @Test
    public void queNoSePuedaCrearSeleccionSinAlbumTest(){

        //preparacion -> given
        Seleccion seleccion = givenUnaSeleccion();
        //ejecucion -> when

        doThrow(SeleccionAlbumNullException.class)
                .when(servicioSeleccion)
                .crearSeleccion(seleccion);

        whenAgregoUnaSeleccion(seleccion);

        //comprobacion -> then
        thenRegistroFalla();

    }

    @Test
    public void queNoSePuedaCrearSeleccionConAmbosCamposVaciosTest(){

        //preparacion -> given
        Seleccion seleccion = givenUnaSeleccion();
        //ejecucion -> when

        doThrow(SeleccionCamposVacíosException.class)
                .when(servicioSeleccion)
                .crearSeleccion(seleccion);

        whenAgregoUnaSeleccion(seleccion);

        //comprobacion -> then
        thenRegistroFalla();

    }

    @Test
    public void queNoSePuedaCrearConCaracteresEspecialesONumerosTest(){

        //preparacion -> given
        Seleccion seleccion = givenUnaSeleccion();
        //ejecucion -> when

        doThrow(SeleccionNombreTieneNumerosOCaracteresEspecialesException.class)
                .when(servicioSeleccion)
                .crearSeleccion(seleccion);

        whenAgregoUnaSeleccion(seleccion);

        //comprobacion -> then
        thenRegistroFallaMensaje(errorCaracteresNumerosSeleccion);

    }

    private void thenRegistroFallaMensaje(String msj) {
        assertThat(mav.getModel().get("error")).isEqualTo(msj);
    }

    @Test
    public void queSeElimineUnaSeleccionTest(){

        //preparacion -> given
        Seleccion seleccion = givenUnaSeleccion();
        //ejecucion -> when
        seleccion.setId(1l);
        int id = (int)(long)seleccion.getId();
        whenEliminoUnaSeleccion(id);

        //comprobacion -> then
        thenRedirectCorrectoSeleccion();

    }

    private void whenEliminoUnaSeleccion(int id) {
        mav=controladorSeleccion.delSelecciones(id);
    }

}
