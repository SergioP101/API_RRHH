package RRHH;

import java.time.LocalDate;
import java.util.Objects;

public class SolicitudCambioTurno {
    private int solicitudID;
    private int usuarioID;
    private int compañeroID;
    private LocalDate fechaSolicitada;
    private EstadoSolicitud estado;

    public SolicitudCambioTurno(int solicitudID, int usuarioID, int compañeroID, LocalDate fechaSolicitada) {
        this.solicitudID = solicitudID;
        this.usuarioID = usuarioID;
        this.compañeroID = compañeroID;
        this.fechaSolicitada = fechaSolicitada;
        this.estado = EstadoSolicitud.PENDIENTE;
    }

    // Getters y setters
    public int getSolicitudID() { return solicitudID; }
    public int getUsuarioID() { return usuarioID; }
    public int getCompañeroID() { return compañeroID; }
    public LocalDate getFechaSolicitada() { return fechaSolicitada; }
    public EstadoSolicitud getEstado() { return estado; }

    public void setEstado(EstadoSolicitud estado) { this.estado = estado; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitudCambioTurno that = (SolicitudCambioTurno) o;
        return solicitudID == that.solicitudID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(solicitudID);
    }
}
