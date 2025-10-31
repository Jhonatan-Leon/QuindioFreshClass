package co.edu.uniquindio.SOLID.utils.Mappers;

import co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO;
import co.edu.uniquindio.SOLID.Model.DTO.ProveedorDTO;
import co.edu.uniquindio.SOLID.Model.Empleado;
import co.edu.uniquindio.SOLID.Model.Proveedor;

public class ProveedorMapper {
    public static Proveedor toDTO(ProveedorDTO dto) {
        if (dto == null) return null;
        return new Proveedor(dto.getNit(),
                dto.getNombre(),
                dto.getContacto(),
                dto.getEmail(),
                dto.getTelefono());
    }

    public static ProveedorDTO toDTO(Proveedor entidad) {
        if (entidad == null) return null;
        return new ProveedorDTO(entidad.getNit(),
                entidad.getNombre(),
                entidad.getContacto(),
                entidad.getEmail(),
                entidad.getTelefono());
    }

    public static void updateEntityFromDTO(Proveedor entidad, ProveedorDTO dto) {
        if (entidad == null || dto == null) return;
        entidad.setNombre(dto.getNombre());
        entidad.setContacto(dto.getContacto());
        entidad.setEmail(dto.getEmail());
        entidad.setTelefono(dto.getTelefono());
    }
}
