package RRHH;

import java.time.LocalDate;
import java.util.List;

public class GeneradorReportes {

    private int siguienteReporteID = 1;

    public ReporteHorasTrabajadas generarReporteHorasTrabajadas(LocalDate fechaDesde, LocalDate fechaHasta, List<Fichaje> fichajes) {
        return new ReporteHorasTrabajadas(siguienteReporteID++, fechaDesde, fechaHasta, fichajes);
    }

    public ReporteTiposPermisos generarReporteTiposPermisos(LocalDate fechaDesde, LocalDate fechaHasta, List<Permiso> permisos) {
        return new ReporteTiposPermisos(siguienteReporteID++, fechaDesde, fechaHasta, permisos);
    }

    // Métodos para generar otros tipos de reportes (estado de solicitudes, etc.)
}