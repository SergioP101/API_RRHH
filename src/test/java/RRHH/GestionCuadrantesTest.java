package RRHH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class GestionCuadrantesTest {

    @Test
    void generarCuadrante_agregaNuevoCuadranteALaLista() {
        GestionCuadrantes gestionCuadrantes = new GestionCuadrantes();
        LocalDate inicio = LocalDate.now();
        LocalDate fin = LocalDate.now().plusWeeks(4);
        gestionCuadrantes.generarCuadrante(1, 101, inicio, fin, 160);
        assertNotNull(gestionCuadrantes.obtenerCuadrantePorUsuarioYFecha(101, inicio));
    }

    @Test
    void obtenerCuadrantePorUsuarioYFecha_devuelveCuadranteCorrectoSiExiste() {
        GestionCuadrantes gestionCuadrantes = new GestionCuadrantes();
        LocalDate inicio = LocalDate.now();
        LocalDate fin = LocalDate.now().plusWeeks(4);
        gestionCuadrantes.generarCuadrante(1, 101, inicio, fin, 160);
        assertEquals(1, gestionCuadrantes.obtenerCuadrantePorUsuarioYFecha(101, inicio).getCuadranteID());
    }

    @Test
    void obtenerCuadrantePorUsuarioYFecha_devuelveNullSiNoExisteParaFecha() {
        GestionCuadrantes gestionCuadrantes = new GestionCuadrantes();
        LocalDate inicio = LocalDate.now();
        LocalDate fin = LocalDate.now().plusWeeks(4);
        gestionCuadrantes.generarCuadrante(1, 101, inicio, fin, 160);
        assertNull(gestionCuadrantes.obtenerCuadrantePorUsuarioYFecha(101, fin.plusDays(1)));
    }

    @Test
    void obtenerCuadrantePorUsuarioYFecha_devuelveNullSiNoExisteParaUsuario() {
        GestionCuadrantes gestionCuadrantes = new GestionCuadrantes();
        LocalDate inicio = LocalDate.now();
        LocalDate fin = LocalDate.now().plusWeeks(4);
        gestionCuadrantes.generarCuadrante(1, 101, inicio, fin, 160);
        assertNull(gestionCuadrantes.obtenerCuadrantePorUsuarioYFecha(999, inicio));
    }
}