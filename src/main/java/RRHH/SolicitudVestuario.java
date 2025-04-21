package RRHH;

import java.util.Objects;

public class SolicitudVestuario {
    private int solicitudID;
    private int usuarioID;
    private TipoVestuario tipoVestuario;
    private String talla;
    private int cantidad;
    private EstadoSolicitud estado;

    public SolicitudVestuario(int solicitudID, int usuarioID, TipoVestuario tipoVestuario, String talla, int cantidad) {
        this.solicitudID = solicitudID;
        this.usuarioID = usuarioID;
        this.tipoVestuario = tipoVestuario;
        this.talla = talla;
        this.cantidad = cantidad;
        this.estado = EstadoSolicitud.PENDIENTE;
    }

    // Getters y setters
    public int getSolicitudID() { return solicitudID; }
    public int getUsuarioID() { return usuarioID; }
    public TipoVestuario getTipoVestuario() { return tipoVestuario; }
    public String getTalla() { return talla; }
    public int getCantidad() { return cantidad; }
    public EstadoSolicitud getEstado() { return estado; }

    public void setEstado(EstadoSolicitud estado) { this.estado = estado; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitudVestuario that = (SolicitudVestuario) o;
        return solicitudID == that.solicitudID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(solicitudID);
    }
}
