package RRHH;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class GestionSolicitudesTest {

    @Test
    void agregarSolicitud_agregaLaSolicitudALaLista() {
        GestionSolicitudes<Permiso> gestionSolicitudes = new GestionSolicitudes<>();
        Permiso permiso = new Permiso(1, 101, TipoPermiso.ENFERMEDAD, LocalDate.now(), LocalDate.now().plusDays(2));
        gestionSolicitudes.agregarSolicitud(permiso);
        assertEquals(1, gestionSolicitudes.obtenerSolicitudesPendientes().size());
    }

    @Test
    void obtenerSolicitudesPendientes_devuelveSoloLasSolicitudesConEstadoPendiente() {
        GestionSolicitudes<Permiso> gestionSolicitudes = new GestionSolicitudes<>();
        Permiso permisoPendiente1 = new Permiso(1, 101, TipoPermiso.ENFERMEDAD, LocalDate.now(), LocalDate.now().plusDays(1));
        Permiso permisoAprobado = new Permiso(2, 102, TipoPermiso.VACACIONES, LocalDate.now().plusWeeks(1), LocalDate.now().plusWeeks(2));
        permisoAprobado.setEstado(EstadoSolicitud.APROBADA);
        Permiso permisoPendiente2 = new Permiso(3, 103, TipoPermiso.CONSULTA_MEDICA, LocalDate.now().plusDays(3), LocalDate.now().plusDays(3));

        gestionSolicitudes.agregarSolicitud(permisoPendiente1);
        gestionSolicitudes.agregarSolicitud(permisoAprobado);
        gestionSolicitudes.agregarSolicitud(permisoPendiente2);

        assertEquals(2, gestionSolicitudes.obtenerSolicitudesPendientes().size());
    }

    @Test
    void actualizarEstadoSolicitud_cambiaElEstadoDeLaSolicitudCorrecta() {
        GestionSolicitudes<Permiso> gestionSolicitudes = new GestionSolicitudes<>();
        Permiso permiso1 = new Permiso(1, 101, TipoPermiso.ENFERMEDAD, LocalDate.now(), LocalDate.now().plusDays(1));
        Permiso permiso2 = new Permiso(2, 102, TipoPermiso.VACACIONES, LocalDate.now().plusWeeks(1), LocalDate.now().plusWeeks(2));

        gestionSolicitudes.agregarSolicitud(permiso1);
        gestionSolicitudes.agregarSolicitud(permiso2);
        
        gestionSolicitudes.actualizarEstadoSolicitud(permiso1.getSolicitudID(), EstadoSolicitud.APROBADA, Permiso.class);
        assertEquals(EstadoSolicitud.APROBADA, permiso1.getEstado());
        assertEquals(EstadoSolicitud.PENDIENTE, permiso2.getEstado());
    }

    @Test
    void actualizarEstadoSolicitud_noHaceNadaSiLaSolicitudNoSeEncuentra() {
        GestionSolicitudes<Permiso> gestionSolicitudes = new GestionSolicitudes<>();
        gestionSolicitudes.actualizarEstadoSolicitud(99, EstadoSolicitud.DENEGADA, Permiso.class);
        // No se puede verificar directamente el estado de un objeto no existente,
        // pero la ausencia de errores indica el comportamiento esperado.
    }
}