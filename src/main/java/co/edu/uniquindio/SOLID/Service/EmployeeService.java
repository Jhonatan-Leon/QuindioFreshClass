package co.edu.uniquindio.SOLID.Service;

import co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO;
import co.edu.uniquindio.SOLID.Model.Empleado;
import co.edu.uniquindio.SOLID.Model.Minimercado;
import co.edu.uniquindio.SOLID.utils.Mappers.EmpleadoMapper;

public class EmployeeService {
    private final Minimercado minimercado;

    public EmployeeService(Minimercado minimercado) {
        this.minimercado = Minimercado.getInstancia();
    }

    public void addEmployee(EmpleadoDTO newEmployee){
        if(newEmployee != null){
         Empleado empleado = EmpleadoMapper.toEntity(newEmployee);
         minimercado.addEmpleado(empleado);
        }
    }

    public EmpleadoDTO createEmployee(EmpleadoDTO newEmployee) {
    }
}
