package RRHH;
import java.time.LocalDateTime;
import java.util.Objects;

public class Fichaje {
    private int fichajeID;
    private int usuarioID;
    private LocalDateTime fechaHoraEntrada;
    private LocalDateTime fechaHoraSalida;
    private String ubicacionEntrada; // Podría ser un objeto Location con latitud y longitud
    private String ubicacionSalida;

    // Constructor para la entrada
    public Fichaje(int fichajeID, int usuarioID, LocalDateTime fechaHoraEntrada, String ubicacionEntrada) {
        this.fichajeID = fichajeID;
        this.usuarioID = usuarioID;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.ubicacionEntrada = ubicacionEntrada;
    }

    // Getters y setters
    public int getFichajeID() { return fichajeID; }
    public int getUsuarioID() { return usuarioID; }
    public LocalDateTime getFechaHoraEntrada() { return fechaHoraEntrada; }
    public LocalDateTime getFechaHoraSalida() { return fechaHoraSalida; }
    public String getUbicacionEntrada() { return ubicacionEntrada; }
    public String getUbicacionSalida() { return ubicacionSalida; }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) { this.fechaHoraSalida = fechaHoraSalida; }
    public void setUbicacionSalida(String ubicacionSalida) { this.ubicacionSalida = ubicacionSalida; }

    public void registrarSalida(LocalDateTime fechaHoraSalida, String ubicacionSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
        this.ubicacionSalida = ubicacionSalida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fichaje fichaje = (Fichaje) o;
        return fichajeID == fichaje.fichajeID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fichajeID);
    }
}