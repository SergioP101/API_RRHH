package RRHH;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // --- Pruebas de Usuario ---
        System.out.println("--- Pruebas de Usuario ---");
        Usuario empleado1 = new Usuario(1, "Carlos Pérez", "12345678A", "carlos.perez@empresa.com", "passwordHash123", "Ventas", new Date());
        System.out.println("Usuario creado: " + empleado1.getNombre());
        if (empleado1.login("12345678A", "passwordHash123")) {
            System.out.println(empleado1.getNombre() + " ha iniciado sesión.");
        }
        empleado1.cambiarContraseña("nuevaPasswordHash456");
        System.out.println("Contraseña de " + empleado1.getNombre() + " cambiada.");

        Fichaje fichajeEntrada1 = new Fichaje(101, empleado1.getUserID(), LocalDateTime.now().minusHours(8), "GPS: 40.4168, -3.7038");
        Fichaje fichajeSalida1 = new Fichaje(102, empleado1.getUserID(), LocalDateTime.now(), "GPS: 40.4168, -3.7038");
        fichajeSalida1.registrarSalida(LocalDateTime.now(), "GPS: 40.4168, -3.7038");
        System.out.println(empleado1.getNombre() + " ha fichado.");

        Permiso permiso1 = new Permiso(201, empleado1.getUserID(), TipoPermiso.ENFERMEDAD, LocalDate.now(), LocalDate.now().plusDays(2));
        System.out.println(empleado1.getNombre() + " solicitó permiso: " + permiso1.getEstado());
        permiso1.setEstado(EstadoSolicitud.APROBADA);
        System.out.println("Permiso de " + empleado1.getNombre() + ": " + permiso1.getEstado());

        InfoUsuario infoEmpleado1 = new InfoUsuario(empleado1.getUserID(), 15, 2, 5, 1760, 0);
        System.out.println("Info " + empleado1.getNombre() + ": Vacaciones=" + infoEmpleado1.getVacacionesPendientes());

        System.out.println("\n--- Pruebas de Administrador ---");
        Administrador admin1 = new Administrador(1001, "admin", "adminHash123");
        System.out.println("Administrador creado: " + admin1.getUsuario());
        if (admin1.login("admin", "adminHash123")) {
            System.out.println("Administrador " + admin1.getUsuario() + " ha iniciado sesión.");
        }

        GestionUsuarios gestionUsuarios = new GestionUsuarios();
        gestionUsuarios.crearUsuario(empleado1);
        Usuario empleadoEncontrado = gestionUsuarios.obtenerUsuarioPorId(1);
        if (empleadoEncontrado != null) {
            System.out.println("Usuario encontrado por ID: " + empleadoEncontrado.getNombre());
        }

        GestionSolicitudes<Object> gestionSolicitudes = new GestionSolicitudes<>();
        gestionSolicitudes.agregarSolicitud(permiso1);
        System.out.println("Solicitudes pendientes: " + gestionSolicitudes.obtenerSolicitudesPendientes().size());
        gestionSolicitudes.actualizarEstadoSolicitud(201, EstadoSolicitud.DENEGADA, Permiso.class);
        System.out.println("Estado del permiso de " + empleado1.getNombre() + ": " + permiso1.getEstado());

        GestionCuadrantes gestionCuadrantes = new GestionCuadrantes();
        gestionCuadrantes.generarCuadrante(10001, empleado1.getUserID(), LocalDate.now(), LocalDate.now().plusWeeks(4), 160);
        Cuadrante cuadranteEmpleado = gestionCuadrantes.obtenerCuadrantePorUsuarioYFecha(empleado1.getUserID(), LocalDate.now().plusDays(5));
        if (cuadranteEmpleado != null) {
            System.out.println("Cuadrante encontrado para " + empleado1.getNombre() + " en la fecha.");
        }

        GestionTiposPermisos gestionTiposPermisos = new GestionTiposPermisos();
        gestionTiposPermisos.agregarTipoPermiso(TipoPermiso.VACACIONES);
        System.out.println("Tipos de permiso disponibles: " + gestionTiposPermisos.obtenerTodosLosTiposPermiso());

        List<Fichaje> listaFichajes = new ArrayList<>();
        listaFichajes.add(fichajeEntrada1);
        listaFichajes.add(fichajeSalida1);
        AccesoFichasEmpleados accesoFichas = new AccesoFichasEmpleados(listaFichajes);
        System.out.println("Fichajes de " + empleado1.getNombre() + ": " + accesoFichas.obtenerFichajesPorEmpleado(empleado1.getUserID()).size());

        System.out.println("\n--- Pruebas de Reportes ---");
        GeneradorReportes generadorReportes = new GeneradorReportes();
        List<Fichaje> fichajesReporte = new ArrayList<>();
        fichajesReporte.add(new Fichaje(103, empleado1.getUserID(), LocalDateTime.now().minusDays(3).withHour(9).withMinute(0), ""));
        fichajesReporte.add(new Fichaje(104, empleado1.getUserID(), LocalDateTime.now().minusDays(3).withHour(17).withMinute(0), ""));
        fichajesReporte.add(new Fichaje(105, empleado1.getUserID(), LocalDateTime.now().minusDays(2).withHour(10).withMinute(0), ""));
        fichajesReporte.add(new Fichaje(106, empleado1.getUserID(), LocalDateTime.now().minusDays(2).withHour(16).withMinute(30), ""));

        ReporteHorasTrabajadas reporteHoras = generadorReportes.generarReporteHorasTrabajadas(LocalDate.now().minusWeeks(1), LocalDate.now(), fichajesReporte);
        System.out.println("\n--- Contenido del Reporte de Horas Trabajadas ---");
        System.out.println(reporteHoras.generarContenido());
        reporteHoras.exportarPDF("reporte_horas.pdf");
        reporteHoras.exportarExcel("reporte_horas.xlsx");

        List<Permiso> permisosReporte = new ArrayList<>();
        permisosReporte.add(new Permiso(202, empleado1.getUserID(), TipoPermiso.ENFERMEDAD, LocalDate.now().minusDays(5), LocalDate.now().minusDays(3)));
        permisosReporte.add(new Permiso(203, empleado1.getUserID(), TipoPermiso.VACACIONES, LocalDate.now().plusWeeks(1), LocalDate.now().plusWeeks(2)));

        ReporteTiposPermisos reporteTipos = generadorReportes.generarReporteTiposPermisos(LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(1), permisosReporte);
        System.out.println("\n--- Contenido del Reporte de Tipos de Permisos ---");
        System.out.println(reporteTipos.generarContenido());
        reporteTipos.exportarPDF("reporte_tipos_permisos.pdf");
        reporteTipos.exportarExcel("reporte_tipos_permisos.xlsx");
    }
}