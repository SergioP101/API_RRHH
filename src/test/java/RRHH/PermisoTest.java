package RRHH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class PermisoTest {

    @Test
    void constructor_estableceEstadoPendiente() {
        LocalDate inicio = LocalDate.now();
        LocalDate fin = LocalDate.now().plusDays(2);
        Permiso permiso = new Permiso(1, 101, TipoPermiso.ENFERMEDAD, inicio, fin);
        assertEquals(EstadoSolicitud.PENDIENTE, permiso.getEstado());
    }

    @Test
    void actualizarEstado_cambiaElEstadoDelPermiso() {
        LocalDate inicio = LocalDate.now();
        LocalDate fin = LocalDate.now().plusDays(2);
        Permiso permiso = new Permiso(1, 101, TipoPermiso.ENFERMEDAD, inicio, fin);
        permiso.setEstado(EstadoSolicitud.APROBADA);
        assertEquals(EstadoSolicitud.APROBADA, permiso.getEstado());
    }

    @Test
    void setDocumentoJustificativoPath_asignaLaRutaCorrectamente() {
        LocalDate inicio = LocalDate.now();
        LocalDate fin = LocalDate.now().plusDays(2);
        Permiso permiso = new Permiso(1, 101, TipoPermiso.ENFERMEDAD, inicio, fin);
        String ruta = "/ruta/al/documento.pdf";
        permiso.setDocumentoJustificativoPath(ruta);
        assertEquals(ruta, permiso.getDocumentoJustificativoPath());
    }
}