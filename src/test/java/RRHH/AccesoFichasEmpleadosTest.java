package RRHH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class AccesoFichasEmpleadosTest {

    @Test
    void obtenerFichajesPorEmpleado_devuelveFichajesDelEmpleadoEspecifico() {
        List<Fichaje> fichajes = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        fichajes.add(new Fichaje(1, 101, now.minusHours(8), ""));
        fichajes.add(new Fichaje(2, 102, now.minusHours(7), ""));
        fichajes.add(new Fichaje(3, 101, now.minusHours(6), ""));

        AccesoFichasEmpleados accesoFichas = new AccesoFichasEmpleados(fichajes);
        assertEquals(2, accesoFichas.obtenerFichajesPorEmpleado(101).size());
    }

    @Test
    void obtenerFichajesPorEmpleado_devuelveListaVaciaSiNoHayFichajesParaElEmpleado() {
        List<Fichaje> fichajes = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        fichajes.add(new Fichaje(1, 101, now.minusHours(8), ""));
        AccesoFichasEmpleados accesoFichas = new AccesoFichasEmpleados(fichajes);
        assertEquals(0, accesoFichas.obtenerFichajesPorEmpleado(999).size());
    }

    @Test
    void obtenerFichajesPorEmpleadoYFecha_devuelveFichajesDentroDelRangoDeFechas() {
        List<Fichaje> fichajes = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        fichajes.add(new Fichaje(1, 101, now.minusDays(2), ""));
        fichajes.add(new Fichaje(2, 101, now.minusDays(1), ""));
        fichajes.add(new Fichaje(3, 101, now, ""));

        AccesoFichasEmpleados accesoFichas = new AccesoFichasEmpleados(fichajes);
        LocalDateTime desde = now.minusDays(1).minusHours(1);
        LocalDateTime hasta = now.plusHours(1);
        assertEquals(2, accesoFichas.obtenerFichajesPorEmpleadoYFecha(101, desde, hasta).size());
    }

    @Test
    void obtenerFichajesPorEmpleadoYFecha_devuelveListaVaciaSiNoHayFichajesEnElRango() {
        List<Fichaje> fichajes = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        fichajes.add(new Fichaje(1, 101, now.minusDays(5), ""));
        AccesoFichasEmpleados accesoFichas = new AccesoFichasEmpleados(fichajes);
        LocalDateTime desde = now.minusDays(1);
        LocalDateTime hasta = now;
        assertEquals(0, accesoFichas.obtenerFichajesPorEmpleadoYFecha(101, desde, hasta).size());
    }
}