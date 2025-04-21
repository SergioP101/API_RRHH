package RRHH;

import java.util.ArrayList;
import java.util.List;

public class GestionTiposPermisos {
    private List<TipoPermiso> tiposPermiso;

    public GestionTiposPermisos() {
        this.tiposPermiso = new ArrayList<>();
        // Inicializar con algunos tipos de permiso por defecto
        tiposPermiso.add(TipoPermiso.ENFERMEDAD);
        tiposPermiso.add(TipoPermiso.ENFERMEDAD_FAMILIAR);
        tiposPermiso.add(TipoPermiso.VACACIONES); // Suponiendo que "VACACIONES" es un tipo
        // ...
    }

    public void agregarTipoPermiso(TipoPermiso nuevoTipoPermiso) {
        if (!tiposPermiso.contains(nuevoTipoPermiso)) {
            tiposPermiso.add(nuevoTipoPermiso);
            System.out.println("Tipo de permiso " + nuevoTipoPermiso + " agregado.");
        } else {
            System.out.println("El tipo de permiso " + nuevoTipoPermiso + " ya existe.");
        }
    }

    public List<TipoPermiso> obtenerTodosLosTiposPermiso() {
        return new ArrayList<>(tiposPermiso); // Devolver una copia para evitar modificaciones externas
    }

    // Métodos para editar o eliminar tipos de permiso si es necesario
}