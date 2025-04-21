package RRHH;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReporteTiposPermisos extends Reporte {
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private List<Permiso> permisos; // Se inyectaría la lista de permisos relevantes

    public ReporteTiposPermisos(int reporteID, LocalDate fechaDesde, LocalDate fechaHasta, List<Permiso> permisos) {
        super(reporteID, "Reporte de Tipos de Permisos");
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.permisos = permisos;
    }

    @Override
    public String generarContenido() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reporte de Tipos de Permisos\n");
        sb.append("Desde: ").append(fechaDesde).append(" Hasta: ").append(fechaHasta).append("\n\n");

        Map<TipoPermiso, Long> conteoPorTipo = permisos.stream()
                .filter(p -> !p.getFechaFin().isBefore(fechaDesde) && !p.getFechaInicio().isAfter(fechaHasta))
                .collect(Collectors.groupingBy(Permiso::getTipoPermiso, Collectors.counting()));

        conteoPorTipo.forEach((tipo, cantidad) -> {
            sb.append("Tipo de Permiso: ").append(tipo).append(" - Cantidad: ").append(cantidad).append("\n");
        });

        return sb.toString();
    }
}