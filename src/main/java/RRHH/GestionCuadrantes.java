package RRHH;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestionCuadrantes {
    private List<Cuadrante> cuadrantes;

    public GestionCuadrantes() {
        this.cuadrantes = new ArrayList<>();
    }

    public void generarCuadrante(int cuadranteID, int usuarioID, LocalDate fechaInicio, LocalDate fechaFin, int horasAnualesConvenio) {
        Cuadrante nuevoCuadrante = new Cuadrante(cuadranteID, usuarioID, fechaInicio, fechaFin, horasAnualesConvenio);
        cuadrantes.add(nuevoCuadrante);
        System.out.println("Cuadrante generado para el usuario " + usuarioID + ".");
    }

    public Cuadrante obtenerCuadrantePorUsuarioYFecha(int usuarioID, LocalDate fecha) {
        return cuadrantes.stream()
                .filter(c -> c.getUsuarioID() == usuarioID && !fecha.isBefore(c.getFechaInicio()) && !fecha.isAfter(c.getFechaFin()))
                .findFirst()
                .orElse(null);
    }

    // Métodos para editar cuadrantes, asignar turnos, etc.
}