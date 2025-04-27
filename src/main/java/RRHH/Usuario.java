package RRHH;

import java.util.Date;
import java.util.Objects;

public class Usuario {
    private int userID;
    private String nombre;
    private String dni;
    private String email;
    private String passwordHash; // Debería ser un hash seguro, no la contraseña plana
    private String departamento;
    private Date fechaAlta;

    // Constructor
    public Usuario(int userID, String nombre, String dni, String email, String passwordHash, String departamento, Date fechaAlta) {
        this.userID = userID;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.passwordHash = passwordHash;
        this.departamento = departamento;
        this.fechaAlta = fechaAlta;
    }

    // Getters y setters (omitiendo setters para userID y fechaAlta para simplificar, ya que suelen ser gestionados internamente)
    public int getUserID() { return userID; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDni() { return dni; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    public Date getFechaAlta() { return fechaAlta; }

    // Métodos de negocio
    public boolean login(String dni, String password) {
        // En una implementación real, aquí se compararía el hash de la contraseña ingresada con passwordHash
        return Objects.equals(this.dni, dni) && Objects.equals(this.passwordHash, password); // Simplificado
    }

    public void cambiarContraseña(String nuevaPasswordHash) {
        // En una implementación real, la contraseña ya debería estar hasheada antes de llegar aquí
        this.passwordHash = nuevaPasswordHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return userID == usuario.userID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID);
    }
}