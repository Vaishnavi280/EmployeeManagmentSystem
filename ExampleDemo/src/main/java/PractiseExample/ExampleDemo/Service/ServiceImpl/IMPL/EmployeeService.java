package PractiseExample.ExampleDemo.Service.ServiceImpl.IMPL;

import PractiseExample.ExampleDemo.Entity.Employee;
import PractiseExample.ExampleDemo.MapperClass.EmployeeMapper;
import PractiseExample.ExampleDemo.Repository.EmployeeRepository;
import PractiseExample.ExampleDemo.Service.ServiceImpl.ServiceInterface;
import PractiseExample.ExampleDemo.dto.EmployeeDTO;
import PractiseExample.ExampleDemo.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService implements ServiceInterface {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.maptoEmployee(employeeDTO);
        Employee savedemployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedemployee);
    }

    @Override
    public EmployeeDTO getEmployeebyId(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee ID does not exist" + employeeId));
                return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDTO> getallEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO UpdateEmployess(Long employeeId, EmployeeDTO updateEmployee) {
      Employee employee=employeeRepository.findById(employeeId).
                orElseThrow(()->new ResourceNotFoundException("Employee ID does not exist" + employeeId));
      employee.setFirstname(updateEmployee.getFirstname());
      employee.setLastname(updateEmployee.getLastname());
      employee.setEmail(updateEmployee.getEmail());
        Employee updatedemployeeobj =  employeeRepository.save(employee);

      return EmployeeMapper.mapToEmployeeDto(updatedemployeeobj);
    }

    @Override
    public void DeleteEmployee(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).
                orElseThrow(()->new ResourceNotFoundException("Employee ID does not exist" + employeeId));
                employeeRepository.deleteById(employeeId);
    }


}
