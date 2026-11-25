package PractiseExample.ExampleDemo.Controller;
import PractiseExample.ExampleDemo.Entity.Employee;
import PractiseExample.ExampleDemo.Service.ServiceImpl.IMPL.EmployeeService;
import PractiseExample.ExampleDemo.Service.ServiceImpl.ServiceInterface;
import PractiseExample.ExampleDemo.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

   private EmployeeService serviceinterface;

   @PostMapping
   public ResponseEntity<EmployeeDTO>createEmployee(@RequestBody EmployeeDTO employeeDTO){
       EmployeeDTO savedEmployee = serviceinterface.createEmployee(employeeDTO);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
   }

   @GetMapping("/{id}")
   public ResponseEntity<EmployeeDTO>getEmployeebyId(@PathVariable("id") Long employeeId){
       EmployeeDTO employeeDTO = serviceinterface.getEmployeebyId(employeeId);
       return ResponseEntity.ok(employeeDTO);
   }

    @GetMapping
   public ResponseEntity<List<EmployeeDTO>>getallEmployees(){
       List<EmployeeDTO> employees = serviceinterface.getallEmployees();
               return ResponseEntity.ok(employees);
   }

   @PutMapping("{id}")
   public ResponseEntity<EmployeeDTO>UpdateEmployess(@PathVariable("id")  Long employeeId ,
                                                    @RequestBody EmployeeDTO updateEmployee){
       EmployeeDTO employeeDTO = serviceinterface.UpdateEmployess(employeeId,updateEmployee);
       return ResponseEntity.ok(employeeDTO);
   }
    @DeleteMapping("{id}")
   public ResponseEntity<String>DeleteEmployee(@PathVariable ("id") Long employeeId){
       serviceinterface.DeleteEmployee(employeeId);
       return ResponseEntity.ok("Employee Deleted Sucessfully");
   }
}
