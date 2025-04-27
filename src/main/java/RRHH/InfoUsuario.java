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


    /**
     * Reduce los días de vacaciones pendientes del usuario.
     *
     * @param diasAReducir El número de días de vacaciones a reducir.
     * @return true si se pudieron reducir los días, false si no hay suficientes vacaciones pendientes.
     * @throws IllegalArgumentException si diasAReducir es negativo.
     */
    public boolean reducirVacaciones(int diasAReducir) {
        if (diasAReducir < 0) {
            throw new IllegalArgumentException("El número de días a reducir no puede ser negativo.");
        }
        if (this.vacacionesPendientes >= diasAReducir) {
            this.vacacionesPendientes -= diasAReducir;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Reduce los días de asuntos propios pendientes del usuario.
     *
     * @param diasAReducir El número de días de asuntos propios a reducir.
     * @return true si se pudieron reducir los días, false si no hay suficientes asuntos propios pendientes.
     * @throws IllegalArgumentException si diasAReducir es negativo.
     */
    public boolean reducirAsuntosPropios(int diasAReducir) {
        if (diasAReducir < 0) {
            throw new IllegalArgumentException("El número de días a reducir no puede ser negativo.");
        }
        if (this.asuntosPropiosPendientes >= diasAReducir) {
            this.asuntosPropiosPendientes -= diasAReducir;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Incrementa el número de justificaciones pendientes del usuario.
     */
    public void incrementarJustificacionesPendientes() {
        this.justificacionesPendientes++;
    }

    /**
     * Reduce el número de justificaciones pendientes del usuario.
     *
     * @return true si había justificaciones pendientes y se redujeron, false si no había justificaciones pendientes.
     */
    public boolean reducirJustificacionesPendientes() {
        if (this.justificacionesPendientes > 0) {
            this.justificacionesPendientes--;
            return true;
        } else {
            return false;
        }
    }

}