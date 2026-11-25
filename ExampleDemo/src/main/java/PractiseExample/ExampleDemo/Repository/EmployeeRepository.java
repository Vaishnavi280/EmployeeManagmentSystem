package PractiseExample.ExampleDemo.Repository;

import PractiseExample.ExampleDemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
