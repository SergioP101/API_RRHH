package RRHH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class CuadranteTest {

    @Test
    void constructor_inicializaHorasRealizadasEnCero() {
        LocalDate inicio = LocalDate.now();
        LocalDate fin = LocalDate.now().plusWeeks(4);
        Cuadrante cuadrante = new Cuadrante(1, 101, inicio, fin, 160);
        assertEquals(0, cuadrante.getHorasRealizadas());
    }

    @Test
    void setHorasRealizadas_actualizaElValorCorrectamente() {
        LocalDate inicio = LocalDate.now();
        LocalDate fin = LocalDate.now().plusWeeks(4);
        Cuadrante cuadrante = new Cuadrante(1, 101, inicio, fin, 160);
        cuadrante.setHorasRealizadas(80);
        assertEquals(80, cuadrante.getHorasRealizadas());
    }
}