package RRHH;

import java.time.LocalDate;

public abstract class Reporte {
    private int reporteID;
    private String nombreReporte;
    private LocalDate fechaGeneracion;

    public Reporte(int reporteID, String nombreReporte) {
        this.reporteID = reporteID;
        this.nombreReporte = nombreReporte;
        this.fechaGeneracion = LocalDate.now();
    }

    // Getters
    public int getReporteID() { return reporteID; }
    public String getNombreReporte() { return nombreReporte; }
    public LocalDate getFechaGeneracion() { return fechaGeneracion; }

    // Método abstracto para generar el contenido específico del reporte
    public abstract String generarContenido();

    // Métodos comunes para exportar (podrían estar en una clase separada de servicio de exportación)
    public void exportarPDF(String rutaArchivo) {
        String contenido = generarContenido();
        // Lógica para convertir 'contenido' a PDF y guardar en 'rutaArchivo' (usando iText u otra librería)
        System.out.println("Reporte " + nombreReporte + " exportado a PDF en: " + rutaArchivo);
        System.out.println("Contenido (simulado):\n" + contenido);
    }

    public void exportarExcel(String rutaArchivo) {
        String contenido = generarContenido();
        // Lógica para convertir 'contenido' a formato Excel y guardar en 'rutaArchivo' (usando Apache POI u otra librería)
        System.out.println("Reporte " + nombreReporte + " exportado a Excel en: " + rutaArchivo);
        System.out.println("Contenido (simulado):\n" + contenido);
    }
}