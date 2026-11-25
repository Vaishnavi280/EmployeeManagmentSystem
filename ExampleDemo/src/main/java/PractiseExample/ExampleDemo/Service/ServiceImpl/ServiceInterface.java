package PractiseExample.ExampleDemo.Service.ServiceImpl;

import PractiseExample.ExampleDemo.dto.EmployeeDTO;

import java.util.List;

public interface ServiceInterface {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeebyId(Long employeeId);
    List<EmployeeDTO>getallEmployees();
    EmployeeDTO UpdateEmployess(Long employeeId , EmployeeDTO updateEmployee);
    void DeleteEmployee(Long employeeId);
}
