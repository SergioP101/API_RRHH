package RRHH;

import java.time.LocalDate;
import java.util.Objects;

public class Permiso {
    private int permisoID;
    private int usuarioID;
    private TipoPermiso tipoPermiso;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoSolicitud estado;
    private String documentoJustificativoPath;

    public Permiso(int permisoID, int usuarioID, TipoPermiso tipoPermiso, LocalDate fechaInicio, LocalDate fechaFin) {
        this.permisoID = permisoID;
        this.usuarioID = usuarioID;
        this.tipoPermiso = tipoPermiso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = EstadoSolicitud.PENDIENTE;
        this.documentoJustificativoPath = null;
    }

    // Getters y setters
    public int getPermisoID() { return permisoID; }
    public int getUsuarioID() { return usuarioID; }
    public TipoPermiso getTipoPermiso() { return tipoPermiso; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public EstadoSolicitud getEstado() { return estado; }
    public String getDocumentoJustificativoPath() { return documentoJustificativoPath; }

    public void setEstado(EstadoSolicitud estado) { this.estado = estado; }
    public void setDocumentoJustificativoPath(String documentoJustificativoPath) { this.documentoJustificativoPath = documentoJustificativoPath; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permiso permiso = (Permiso) o;
        return permisoID == permiso.permisoID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(permisoID);
    }

    public int getSolicitudID() {
        return permisoID;
    }
}
