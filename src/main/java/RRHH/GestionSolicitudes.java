package RRHH;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestionSolicitudes<T> {
    private List<T> solicitudes;

    public GestionSolicitudes() {
        this.solicitudes = new ArrayList<>();
    }

    public void agregarSolicitud(T solicitud) {
        this.solicitudes.add(solicitud);
        System.out.println("Solicitud agregada: " + solicitud.getClass().getSimpleName());
    }

    public List<T> obtenerSolicitudesPendientes() {
        return solicitudes.stream()
                .filter(s -> {
                    if (s instanceof SolicitudCambioTurno) {
                        return ((SolicitudCambioTurno) s).getEstado() == EstadoSolicitud.PENDIENTE;
                    } else if (s instanceof Permiso) {
                        return ((Permiso) s).getEstado() == EstadoSolicitud.PENDIENTE;
                    } else if (s instanceof SolicitudVestuario) {
                        return ((SolicitudVestuario) s).getEstado() == EstadoSolicitud.PENDIENTE;
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    // Métodos para aprobar, denegar solicitudes (se necesitarían métodos más específicos por tipo de solicitud)
    public void actualizarEstadoSolicitud(int solicitudID, EstadoSolicitud nuevoEstado, Class<T> type) {
        for (T solicitud : solicitudes) {
            if (type == SolicitudCambioTurno.class && ((SolicitudCambioTurno) solicitud).getSolicitudID() == solicitudID) {
                ((SolicitudCambioTurno) solicitud).setEstado(nuevoEstado);
                System.out.println("Solicitud de cambio de turno " + solicitudID + " actualizada a " + nuevoEstado);
                return;
            } else if (type == Permiso.class && ((Permiso) solicitud).getPermisoID() == solicitudID) {
                ((Permiso) solicitud).setEstado(nuevoEstado);
                System.out.println("Permiso " + solicitudID + " actualizado a " + nuevoEstado);
                return;
            } else if (type == SolicitudVestuario.class && ((SolicitudVestuario) solicitud).getSolicitudID() == solicitudID) {
                ((SolicitudVestuario) solicitud).setEstado(nuevoEstado);
                System.out.println("Solicitud de vestuario " + solicitudID + " actualizada a " + nuevoEstado);
                return;
            }
        }
        System.out.println("Solicitud con ID " + solicitudID + " no encontrada.");
    }

    public void actualizarEstadoSolicitud(T solicitudID, T estadoSolicitud, T permisoClass) {
        
    }

    // Otros métodos para filtrar solicitudes por usuario, fecha, etc.
}