package RRHH;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReporteHorasTrabajadas extends Reporte {
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private List<Fichaje> fichajes; // Se inyectaría la lista de fichajes relevantes

    public ReporteHorasTrabajadas(int reporteID, LocalDate fechaDesde, LocalDate fechaHasta, List<Fichaje> fichajes) {
        super(reporteID, "Reporte de Horas Trabajadas");
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.fichajes = fichajes;
    }

    @Override
    public String generarContenido() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reporte de Horas Trabajadas\n");
        sb.append("Desde: ").append(fechaDesde).append(" Hasta: ").append(fechaHasta).append("\n\n");

        // Agrupar fichajes por usuario
        Map<Integer, List<Fichaje>> fichajesPorUsuario = fichajes.stream()
                .filter(f -> !f.getFechaHoraEntrada().toLocalDate().isBefore(fechaDesde) &&
                        !f.getFechaHoraEntrada().toLocalDate().isAfter(fechaHasta) &&
                        f.getFechaHoraSalida() != null)
                .collect(Collectors.groupingBy(Fichaje::getUsuarioID));

        // Simular la obtención del nombre del usuario (en un sistema real, se consultaría la tabla de usuarios)
        // Aquí usamos IDs como nombres para simplificar
        fichajesPorUsuario.forEach((usuarioId, listaFichajes) -> {
            long totalMinutosTrabajados = 0;
            sb.append("Usuario ID: ").append(usuarioId).append("\n");
            for (Fichaje fichaje : listaFichajes) {
                long minutos = java.time.Duration.between(fichaje.getFechaHoraEntrada(), fichaje.getFechaHoraSalida()).toMinutes();
                totalMinutosTrabajados += minutos;
                sb.append("  - ").append(fichaje.getFechaHoraEntrada().toLocalDate())
                        .append(": Entrada ").append(fichaje.getFechaHoraEntrada().toLocalTime())
                        .append(" - Salida ").append(fichaje.getFechaHoraSalida().toLocalTime())
                        .append(" (").append(minutos / 60).append(" horas ").append(minutos % 60).append(" minutos)\n");
            }
            sb.append("  Total trabajado: ").append(totalMinutosTrabajados / 60).append(" horas ").append(totalMinutosTrabajados % 60).append(" minutos\n\n");
        });

        return sb.toString();
    }
}