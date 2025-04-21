package RRHH;

import java.time.LocalDate;
import java.util.Objects;

public class Cuadrante {
    private int cuadranteID;
    private int usuarioID;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int horasAnualesConvenio;
    private int horasRealizadas;

    public Cuadrante(int cuadranteID, int usuarioID, LocalDate fechaInicio, LocalDate fechaFin, int horasAnualesConvenio) {
        this.cuadranteID = cuadranteID;
        this.usuarioID = usuarioID;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horasAnualesConvenio = horasAnualesConvenio;
        this.horasRealizadas = 0; // Inicialmente las horas realizadas son 0
    }

    // Getters y setters
    public int getCuadranteID() { return cuadranteID; }
    public int getUsuarioID() { return usuarioID; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public int getHorasAnualesConvenio() { return horasAnualesConvenio; }
    public int getHorasRealizadas() { return horasRealizadas; }

    public void setHorasRealizadas(int horasRealizadas) { this.horasRealizadas = horasRealizadas; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuadrante cuadrante = (Cuadrante) o;
        return cuadranteID == cuadrante.cuadranteID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuadranteID);
    }
}