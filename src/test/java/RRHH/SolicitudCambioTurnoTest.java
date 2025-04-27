package RRHH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class SolicitudCambioTurnoTest {

    @Test
    void constructor_estableceEstadoPendiente() {
        LocalDate fechaSolicitada = LocalDate.now().plusDays(7);
        SolicitudCambioTurno solicitud = new SolicitudCambioTurno(1, 101, 102, fechaSolicitada);
        assertEquals(EstadoSolicitud.PENDIENTE, solicitud.getEstado());
    }

    @Test
    void setEstado_actualizaElEstadoDeLaSolicitud() {
        LocalDate fechaSolicitada = LocalDate.now().plusDays(7);
        SolicitudCambioTurno solicitud = new SolicitudCambioTurno(1, 101, 102, fechaSolicitada);
        solicitud.setEstado(EstadoSolicitud.APROBADA);
        assertEquals(EstadoSolicitud.APROBADA, solicitud.getEstado());
    }
}