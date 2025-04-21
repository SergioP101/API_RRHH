package RRHH;

import java.util.Objects;

public class InfoUsuario {
    private int usuarioID;
    private int vacacionesPendientes;
    private int asuntosPropiosPendientes;
    private int diasAntiguedad;
    private int computoHorasAnualConvenio;
    private int justificacionesPendientes;

    public InfoUsuario(int usuarioID, int vacacionesPendientes, int asuntosPropiosPendientes, int diasAntiguedad, int computoHorasAnualConvenio, int justificacionesPendientes) {
        this.usuarioID = usuarioID;
        this.vacacionesPendientes = vacacionesPendientes;
        this.asuntosPropiosPendientes = asuntosPropiosPendientes;
        this.diasAntiguedad = diasAntiguedad;
        this.computoHorasAnualConvenio = computoHorasAnualConvenio;
        this.justificacionesPendientes = justificacionesPendientes;
    }

    // Getters y setters
    public int getUsuarioID() { return usuarioID; }
    public int getVacacionesPendientes() { return vacacionesPendientes; }
    public void setVacacionesPendientes(int vacacionesPendientes) { this.vacacionesPendientes = vacacionesPendientes; }
    public int getAsuntosPropiosPendientes() { return asuntosPropiosPendientes; }
    public void setAsuntosPropiosPendientes(int asuntosPropiosPendientes) { this.asuntosPropiosPendientes = asuntosPropiosPendientes; }
    public int getDiasAntiguedad() { return diasAntiguedad; }
    public int getComputoHorasAnualConvenio() { return computoHorasAnualConvenio; }
    public int getJustificacionesPendientes() { return justificacionesPendientes; }
    public void setJustificacionesPendientes(int justificacionesPendientes) { this.justificacionesPendientes = justificacionesPendientes; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoUsuario that = (InfoUsuario) o;
        return usuarioID == that.usuarioID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioID);
    }
}