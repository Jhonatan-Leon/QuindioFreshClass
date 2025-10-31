package co.edu.uniquindio.SOLID.utils.Mappers;

import co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO;
import co.edu.uniquindio.SOLID.Model.Empleado;

public class EmpleadoMapper {
    public static EmpleadoDTO toDTO(Empleado entidad) {
        if (entidad == null) return null;
        return new EmpleadoDTO(
            entidad.getId(),
            entidad.getNombre(),
            entidad.getRol(),
            entidad.isActivo()
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

    public static void updateEntityFromDTO(Empleado entidad, EmpleadoDTO dto) {
        if (entidad == null || dto == null) return;
        entidad.setNombre(dto.getNombre());
        entidad.setRol(dto.getRol());
    }
}
