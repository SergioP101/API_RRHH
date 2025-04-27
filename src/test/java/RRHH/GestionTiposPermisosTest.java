package RRHH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GestionTiposPermisosTest {

    @Test
    void agregarTipoPermiso_agregaNuevoTipoSiNoExiste() {
        GestionTiposPermisos gestionTiposPermisos = new GestionTiposPermisos();
        TipoPermiso nuevoTipo = TipoPermiso.MATRIMONIO;
        gestionTiposPermisos.agregarTipoPermiso(nuevoTipo);
        assertTrue(gestionTiposPermisos.obtenerTodosLosTiposPermiso().contains(nuevoTipo));
    }

    @Test
    void agregarTipoPermiso_noAgregaTipoSiYaExiste() {
        GestionTiposPermisos gestionTiposPermisos = new GestionTiposPermisos();
        TipoPermiso tipoExistente = TipoPermiso.ENFERMEDAD;
        int initialSize = gestionTiposPermisos.obtenerTodosLosTiposPermiso().size();
        gestionTiposPermisos.agregarTipoPermiso(tipoExistente);
        assertEquals(initialSize, gestionTiposPermisos.obtenerTodosLosTiposPermiso().size());
    }

    @Test
    void obtenerTodosLosTiposPermiso_devuelveListaConTiposIniciales() {
        GestionTiposPermisos gestionTiposPermisos = new GestionTiposPermisos();
        assertFalse(gestionTiposPermisos.obtenerTodosLosTiposPermiso().isEmpty());
        assertTrue(gestionTiposPermisos.obtenerTodosLosTiposPermiso().contains(TipoPermiso.ENFERMEDAD));
    }
}