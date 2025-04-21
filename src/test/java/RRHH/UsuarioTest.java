package RRHH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

class UsuarioTest {

    @Test
    void login_conCredencialesCorrectas_devuelveTrue() {
        Usuario usuario = new Usuario(1, "Test User", "testDNI", "test@example.com", "passwordHash", "IT", new Date());
        assertTrue(usuario.login("testDNI", "passwordHash"));
    }

    @Test
    void login_conDNIIncorrecto_devuelveFalse() {
        Usuario usuario = new Usuario(1, "Test User", "testDNI", "test@example.com", "passwordHash", "IT", new Date());
        assertFalse(usuario.login("wrongDNI", "passwordHash"));
    }

    @Test
    void login_conPasswordIncorrecta_devuelveFalse() {
        Usuario usuario = new Usuario(1, "Test User", "testDNI", "test@example.com", "passwordHash", "IT", new Date());
        assertFalse(usuario.login("testDNI", "wrongPassword"));
    }

    @Test
    void cambiarContraseña_actualizaPasswordHash() {
        Usuario usuario = new Usuario(1, "Test User", "testDNI", "test@example.com", "oldPasswordHash", "IT", new Date());
        usuario.cambiarContraseña("newPasswordHash");
        assertEquals("newPasswordHash", usuario.getPasswordHash());
    }
}