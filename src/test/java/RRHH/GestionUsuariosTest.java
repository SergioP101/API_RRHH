package RRHH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

class GestionUsuariosTest {

    @Test
    void crearUsuario_agregaNuevoUsuarioALaLista() {
        GestionUsuarios gestionUsuarios = new GestionUsuarios();
        Usuario usuario = new Usuario(1, "Test User", "testDNI", "test@example.com", "passwordHash", "IT", new Date());
        gestionUsuarios.crearUsuario(usuario);
        assertEquals(usuario, gestionUsuarios.obtenerUsuarioPorId(1));
    }

    @Test
    void crearUsuario_noAgregaUsuarioSiYaExistePorDNI() {
        GestionUsuarios gestionUsuarios = new GestionUsuarios();
        Usuario usuario1 = new Usuario(1, "Test User 1", "testDNI", "test1@example.com", "hash1", "IT", new Date());
        Usuario usuario2 = new Usuario(2, "Test User 2", "testDNI", "test2@example.com", "hash2", "HR", new Date());
        gestionUsuarios.crearUsuario(usuario1);
        gestionUsuarios.crearUsuario(usuario2);
        assertEquals(usuario1, gestionUsuarios.obtenerUsuarioPorId(1));
        assertNull(gestionUsuarios.obtenerUsuarioPorId(2)); // El segundo usuario no se agregó
    }

    @Test
    void obtenerUsuarioPorId_devuelveUsuarioCorrectoSiExiste() {
        GestionUsuarios gestionUsuarios = new GestionUsuarios();
        Usuario usuario = new Usuario(1, "Test User", "testDNI", "test@example.com", "passwordHash", "IT", new Date());
        gestionUsuarios.crearUsuario(usuario);
        assertEquals(usuario, gestionUsuarios.obtenerUsuarioPorId(1));
    }

    @Test
    void obtenerUsuarioPorId_devuelveNullSiNoExiste() {
        GestionUsuarios gestionUsuarios = new GestionUsuarios();
        assertNull(gestionUsuarios.obtenerUsuarioPorId(99));
    }
}