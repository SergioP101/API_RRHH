package RRHH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolicitudVestuarioTest {

    @Test
    void constructor_estableceEstadoPendiente() {
        SolicitudVestuario solicitud = new SolicitudVestuario(1, 101, TipoVestuario.CAMISETA, "M", 2);
        assertEquals(EstadoSolicitud.PENDIENTE, solicitud.getEstado());
    }

    @Test
    void setEstado_actualizaElEstadoDeLaSolicitud() {
        SolicitudVestuario solicitud = new SolicitudVestuario(1, 101, TipoVestuario.CAMISETA, "M", 2);
        solicitud.setEstado(EstadoSolicitud.DENEGADA);
        assertEquals(EstadoSolicitud.DENEGADA, solicitud.getEstado());
    }
}
