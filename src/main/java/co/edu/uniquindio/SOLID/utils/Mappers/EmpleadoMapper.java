package co.edu.uniquindio.SOLID.utils.Mappers;

import co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO;
import co.edu.uniquindio.SOLID.Model.Empleado;

public class EmpleadoMapper {
    public static EmpleadoDTO toDTO(Empleado entidad) {
        if (entidad == null) return null;
        return new EmpleadoDTO(
            entidad.getId(),
            entidad.getNombre(),
            entidad.getRol()
        );
    }

    public static Empleado toEntity(EmpleadoDTO dto) {
        if (dto == null) return null;
        return new Empleado(
                dto.getId(),
                dto.getNombre(),
                dto.getRol()
        );
    }

    public static Empleado updateEntityFromDTO(Empleado entidad, EmpleadoDTO dto) {
        if (entidad == null || dto == null) return null;
        entidad.setNombre(dto.getNombre());
        entidad.setRol(dto.getRol());
        return entidad;
    }
}
