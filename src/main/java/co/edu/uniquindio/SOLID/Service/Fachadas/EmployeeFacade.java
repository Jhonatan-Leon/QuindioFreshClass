package co.edu.uniquindio.SOLID.Service.Fachadas;

import co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO;
import co.edu.uniquindio.SOLID.Model.Empleado;
import co.edu.uniquindio.SOLID.Model.Minimercado;
import co.edu.uniquindio.SOLID.Service.EmployeeService;

public class EmployeeFacade {
    private static EmployeeFacade Instance;
    private final EmployeeService employeeService = EmployeeService.getInstance();
    private final Minimercado minimercado = Minimercado.getInstancia();

    public static EmployeeFacade getInstance(){
        if(Instance == null){
            Instance = new EmployeeFacade();
        }
        return Instance;
    }

    public EmpleadoDTO addEmployee(EmpleadoDTO newEmployee){
        return employeeService.createEmployee(newEmployee);
    }

    public Empleado searchEmployee(String Id){
        return employeeService.searchEmployee(Id);
    }

    public EmpleadoDTO updateEmployee(EmpleadoDTO employee){
        return employeeService.updateEmployee(employee);
    }

    public void deleteEmployee(String Id){
        employeeService.deleteEmployee(Id);
    }

    public EmpleadoDTO lockEmployee(String id,boolean state){
        return employeeService.lockEmployee(id,state);
    }

    public EmpleadoDTO activateEmployee(String id, boolean state){
        return employeeService.activateEmployee(id, state);
    }

    public EmpleadoDTO getAllEmployee(){
        return employeeService.getAll();
    }

}
