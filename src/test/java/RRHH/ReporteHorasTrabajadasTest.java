package RRHH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class ReporteHorasTrabajadasTest {

    @Test
    void generarContenido_calculaCorrectamenteLasHorasTrabajadas() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime entrada = now.minusHours(8);
        List<Fichaje> fichajes = new ArrayList<>();
        Fichaje fichaje = new Fichaje(1, 101, entrada, "");
        fichaje.registrarSalida(now, "");
        fichajes.add(fichaje);

        ReporteHorasTrabajadas reporte = new ReporteHorasTrabajadas(1, LocalDate.now().minusDays(1), LocalDate.now(), fichajes);
        String contenido = reporte.generarContenido();
        assertTrue(contenido.contains("Total trabajado: 8 horas 0 minutos"));
    }

    @Test
    void generarContenido_filtraFichajesPorRangoDeFechas() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime haceDosDiasEntrada = now.minusDays(2).with(LocalTime.of(9, 0));
        LocalDateTime haceDosDiasSalida = now.minusDays(2).with(LocalTime.of(17, 0));
        LocalDateTime ayerEntrada = now.minusDays(1).with(LocalTime.of(10, 0));
        LocalDateTime ayerSalida = now.minusDays(1).with(LocalTime.of(18, 0));

        List<Fichaje> fichajes = new ArrayList<>();
        Fichaje fichajeHaceDosDiasEntrada = new Fichaje(1, 101, haceDosDiasEntrada, "");
        fichajeHaceDosDiasEntrada.registrarSalida(haceDosDiasSalida, "");
        fichajes.add(fichajeHaceDosDiasEntrada);

        Fichaje fichajeAyerEntrada = new Fichaje(3, 101, ayerEntrada, "");
        fichajeAyerEntrada.registrarSalida(ayerSalida, "");
        fichajes.add(fichajeAyerEntrada);

        ReporteHorasTrabajadas reporte = new ReporteHorasTrabajadas(1, LocalDate.now().minusDays(1), LocalDate.now().minusDays(1), fichajes);
        String contenido = reporte.generarContenido();
        assertTrue(contenido.contains("Total trabajado: 8 horas 0 minutos"));
        assertFalse(contenido.contains(now.minusDays(2).toLocalDate().toString()));
    }
}