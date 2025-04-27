package RRHH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class ReporteTiposPermisosTest {

    @Test
    void generarContenido_filtraPermisosPorRangoDeFechas() {
        List<Permiso> permisos = new ArrayList<>();
        LocalDate now = LocalDate.now();
        // Permiso de ENFERMEDAD DENTRO del rango del reporte (2025-04-14 a 2025-04-20)
        permisos.add(new Permiso(1, 101, TipoPermiso.ENFERMEDAD, now.minusDays(5), now.minusDays(3))); // 2025-04-16 a 2025-04-18
        // Permiso de VACACIONES FUERA del rango del reporte
        permisos.add(new Permiso(2, 102, TipoPermiso.VACACIONES, now.plusDays(5), now.plusDays(7))); // 2025-04-26 a 2025-04-28

        // Rango del Reporte: 2025-04-14 a 2025-04-20
        ReporteTiposPermisos reporte = new ReporteTiposPermisos(1, now.minusDays(7), now.minusDays(1), permisos);
        String contenido = reporte.generarContenido();
        assertTrue(contenido.contains("Tipo de Permiso: ENFERMEDAD - Cantidad: 1"));
        assertFalse(contenido.contains("VACACIONES"));
    }

    @Test
    void generarContenido_cuentaCorrectamenteLosPermisosPorTipo() {
        List<Permiso> permisos = new ArrayList<>();
        LocalDate now = LocalDate.now();
        permisos.add(new Permiso(1, 101, TipoPermiso.ENFERMEDAD, now.minusDays(1), now.minusDays(1)));
        permisos.add(new Permiso(2, 102, TipoPermiso.VACACIONES, now.plusDays(7), now.plusDays(10)));
        permisos.add(new Permiso(3, 101, TipoPermiso.ENFERMEDAD, now, now));

        ReporteTiposPermisos reporte = new ReporteTiposPermisos(1, now.minusMonths(1), now.plusMonths(1), permisos);
        String contenido = reporte.generarContenido();
        assertTrue(contenido.contains("Tipo de Permiso: ENFERMEDAD - Cantidad: 2"));
        assertTrue(contenido.contains("Tipo de Permiso: VACACIONES - Cantidad: 1"));
    }

    // Puedes añadir más pruebas para verificar el formato del contenido, etc.
}