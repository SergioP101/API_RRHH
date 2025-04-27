package RRHH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {

    @Test
    void login_conCredencialesCorrectas_devuelveTrue() {
        Administrador admin = new Administrador(1, "adminUser", "adminPasswordHash");
        assertTrue(admin.login("adminUser", "adminPasswordHash"));
    }

    @Test
    void login_conUsuarioIncorrecto_devuelveFalse() {
        Administrador admin = new Administrador(1, "adminUser", "adminPasswordHash");
        assertFalse(admin.login("wrongUser", "adminPasswordHash"));
    }

    @Test
    void login_conPasswordIncorrecta_devuelveFalse() {
        Administrador admin = new Administrador(1, "adminUser", "adminPasswordHash");
        assertFalse(admin.login("adminUser", "wrongPassword"));
    }
}