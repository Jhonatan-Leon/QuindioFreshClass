package co.edu.uniquindio.SOLID.utils.Mappers;

import co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO;
import co.edu.uniquindio.SOLID.Model.DTO.ProveedorDTO;
import co.edu.uniquindio.SOLID.Model.Empleado;
import co.edu.uniquindio.SOLID.Model.Proveedor;

public class ProveedorMapper {
    public static Proveedor toEntity(ProveedorDTO dto) {
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
        if (dto.getNombre() != null && !dto.getNombre().isEmpty()) {
            entidad.setNombre(dto.getNombre());
        }
        if (dto.getContacto() != null && !dto.getContacto().isEmpty()) {
            entidad.setContacto(dto.getContacto());
        }
        if (dto.getEmail() != null && !dto.getEmail().isEmpty()) {
            entidad.setEmail(dto.getEmail());
        }
        if (dto.getTelefono() != null && !dto.getTelefono().isEmpty()) {
            entidad.setTelefono(dto.getTelefono());
        }
    }

}
