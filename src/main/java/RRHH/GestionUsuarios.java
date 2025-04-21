package RRHH;

import java.util.ArrayList;
import java.util.List;

public class GestionUsuarios {
    private List<Usuario> usuarios;

    public GestionUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public void crearUsuario(Usuario nuevoUsuario) {
        // Lógica para verificar si el usuario ya existe (por DNI, email, etc.)
        if (usuarios.stream().noneMatch(u -> u.getDni().equals(nuevoUsuario.getDni()))) {
            usuarios.add(nuevoUsuario);
            System.out.println("Usuario " + nuevoUsuario.getNombre() + " creado.");
        } else {
            System.out.println("Error: El usuario con DNI " + nuevoUsuario.getDni() + " ya existe.");
        }
    }

    public Usuario obtenerUsuarioPorId(int usuarioID) {
        return usuarios.stream()
                .filter(u -> u.getUserID() == usuarioID)
                .findFirst()
                .orElse(null);
    }

    // Otros métodos para buscar, editar, desactivar usuarios, etc.
}