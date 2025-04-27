package RRHH;

import java.util.Objects;

public class Administrador {
    private int administradorID;
    private String usuario;
    private String passwordHash; // Debería ser un hash seguro

    public Administrador(int administradorID, String usuario, String passwordHash) {
        this.administradorID = administradorID;
        this.usuario = usuario;
        this.passwordHash = passwordHash;
    }

    // Getters y setters
    public int getAdministradorID() { return administradorID; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public boolean login(String usuario, String password) {
        // Comparar el hash de la contraseña ingresada con passwordHash
        return Objects.equals(this.usuario, usuario) && Objects.equals(this.passwordHash, password); // Simplificado
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return administradorID == that.administradorID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(administradorID);
    }
}