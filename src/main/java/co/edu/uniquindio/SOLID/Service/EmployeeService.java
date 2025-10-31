package co.edu.uniquindio.SOLID.Service;

import co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO;
import co.edu.uniquindio.SOLID.Model.Empleado;
import co.edu.uniquindio.SOLID.Model.Minimercado;
import co.edu.uniquindio.SOLID.utils.Mappers.EmpleadoMapper;

public class EmployeeService {
    private static EmployeeService Instance;
    private final Minimercado minimercado;

    public static EmployeeService getInstance() {
        if (Instance == null) {
            Instance = new EmployeeService(Minimercado.getInstancia());
        }
        return Instance;
    }

    public EmployeeService(Minimercado minimercado) {
        this.minimercado = Minimercado.getInstancia();
    }

    public void addEmployee(EmpleadoDTO newEmployee){
        if(newEmployee != null){
         Empleado empleado = EmpleadoMapper.toEntity(newEmployee);
         minimercado.addEmpleado(empleado);
        }
    }

    public EmpleadoDTO getAll(){
        return minimercado.getEmpleados().stream().findFirst().map(EmpleadoMapper::toDTO).orElse(null);
    }

    public EmpleadoDTO createEmployee(EmpleadoDTO newEmployee) {
        if(searchEmployee(newEmployee.getId()) != null){
            throw new IllegalArgumentException("Ya existe un empleado con ese ID");
        }
        Empleado emp = EmpleadoMapper.toEntity(newEmployee);
        minimercado.addEmpleado(emp);
        return EmpleadoMapper.toDTO(emp);
    }


    public Empleado searchEmployee(String id){
        for(Empleado e: minimercado.getEmpleados()){
            if(e.getId().equals(id)) return e;
        }
        return null;
    }

    public EmpleadoDTO updateEmployee(EmpleadoDTO employee) {
        Empleado e = searchEmployee(employee.getId());

        if (e == null) {
            throw new IllegalArgumentException("No existe un empleado con ese ID");
        }

        if (employee.getNombre() != null) e.setNombre(employee.getNombre());
        if (employee.getRol() != null) e.setRol(employee.getRol());
        if (false) {if (employee.getActivo()) e.activar();else e.inactivar(); }
        return EmpleadoMapper.toDTO(e);

    }

    public void deleteEmployee(String id){
        Empleado e = searchEmployee(id);
        if(e == null){
            throw new IllegalArgumentException("No existe un empleado con ese ID");
        }
        minimercado.eliminarEmpleado(e);
    }

    public EmpleadoDTO lockEmployee(String id,boolean state){
        Empleado e = searchEmployee(id);
        if(e == null){
            throw new IllegalArgumentException("No existe un empleado con ese ID");
        }
        if(state){
            e.activar();
        }else{
            e.inactivar();
        }
        return EmpleadoMapper.toDTO(e);
    }

    public EmpleadoDTO activateEmployee(String id, boolean state){
        Empleado e = searchEmployee(id);
        if(e == null){
            throw new IllegalArgumentException("No existe un empleado con ese ID");
        }
        if(state){
            e.activar();
        }else{
            e.inactivar();
        }
        return EmpleadoMapper.toDTO(e);
    }


}
