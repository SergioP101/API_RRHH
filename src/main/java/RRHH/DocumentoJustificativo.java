package RRHH;

import java.time.LocalDateTime;
import java.util.Objects;

public class DocumentoJustificativo {
    private int documentoID;
    private int permisoID;
    private int usuarioID;
    private LocalDateTime fechaSubida;
    private String nombreArchivo;
    private String rutaArchivo;

    public DocumentoJustificativo(int documentoID, int permisoID, int usuarioID, String nombreArchivo, String rutaArchivo) {
        this.documentoID = documentoID;
        this.permisoID = permisoID;
        this.usuarioID = usuarioID;
        this.fechaSubida = LocalDateTime.now();
        this.nombreArchivo = nombreArchivo;
        this.rutaArchivo = rutaArchivo;
    }

    // Getters y setters
    public int getDocumentoID() { return documentoID; }
    public int getPermisoID() { return permisoID; }
    public int getUsuarioID() { return usuarioID; }
    public LocalDateTime getFechaSubida() { return fechaSubida; }
    public String getNombreArchivo() { return nombreArchivo; }
    public String getRutaArchivo() { return rutaArchivo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentoJustificativo that = (DocumentoJustificativo) o;
        return documentoID == that.documentoID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentoID);
    }
}