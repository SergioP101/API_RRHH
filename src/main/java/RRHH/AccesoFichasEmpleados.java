package RRHH;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AccesoFichasEmpleados {
    // Necesitaría una forma de acceder a la lista de fichajes (probablemente a través de un servicio)
    private List<Fichaje> todosLosFichajes; // Esto se inyectaría o se obtendría de un servicio

    public AccesoFichasEmpleados(List<Fichaje> todosLosFichajes) {
        this.todosLosFichajes = todosLosFichajes;
    }

    public List<Fichaje> obtenerFichajesPorEmpleado(int usuarioID) {
        return todosLosFichajes.stream()
                .filter(f -> f.getUsuarioID() == usuarioID)
                .collect(Collectors.toList());
    }

    public List<Fichaje> obtenerFichajesPorEmpleadoYFecha(int usuarioID, LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
        return todosLosFichajes.stream()
                .filter(f -> f.getUsuarioID() == usuarioID &&
                        !f.getFechaHoraEntrada().isBefore(fechaDesde) &&
                        (f.getFechaHoraSalida() == null || !f.getFechaHoraSalida().isAfter(fechaHasta)))
                .collect(Collectors.toList());
    }

    // Otros métodos para filtrar fichajes por fecha, departamento, etc.
}
