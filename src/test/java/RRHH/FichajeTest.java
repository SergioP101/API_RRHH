package RRHH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

class FichajeTest {

    @Test
    void registrarSalida_estableceFechaHoraSalidaYUbicacionSalida() {
        LocalDateTime entrada = LocalDateTime.now().minusHours(8);
        Fichaje fichaje = new Fichaje(1, 101, entrada, "GPS Entrada");
        LocalDateTime salida = LocalDateTime.now();
        String ubicacionSalida = "GPS Salida";
        fichaje.registrarSalida(salida, ubicacionSalida);
        assertEquals(salida, fichaje.getFechaHoraSalida());
        assertEquals(ubicacionSalida, fichaje.getUbicacionSalida());
    }
}
