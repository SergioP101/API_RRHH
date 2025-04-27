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
    public void eliminarCuadrante(int cuadranteID) {
        // Buscar el cuadrante por su ID
        Cuadrante cuadranteAEliminar = cuadrantes.stream()
                .filter(c -> c.getCuadranteID() == cuadranteID)
                .findFirst()
                .orElse(null);

        // Verificar si se encontró el cuadrante
        if (cuadranteAEliminar != null) {
            cuadrantes.remove(cuadranteAEliminar);
            System.out.println("Cuadrante con ID " + cuadranteID + " eliminado correctamente.");
        } else {
            System.out.println("Cuadrante con ID " + cuadranteID + " no encontrado.");
        }
    }


    // Métodos para editar cuadrantes, asignar turnos, etc.
}