package com.microservice.employee_service.service.employeeServiceImpl;

import com.microservice.employee_service.dto.EmployeeDto;
import com.microservice.employee_service.entity.Employee;
import com.microservice.employee_service.repository.EmployeeRepository;
import com.microservice.employee_service.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository ;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository =employeeRepository ;
    }



    /**
     * Add new Employee
     */
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        //Convert EmployeeDto to Employee entity
        Employee emp = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
      Employee savedEmployee =   employeeRepository.save(emp) ;

      //Convert Employee entity to EmployeeDto
      EmployeeDto empDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName() ,
                savedEmployee.getEmail()
        ) ;
        return empDto ;
    }

    /**
     * Get employee by employeeId
     */

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
      Optional<Employee> employee = employeeRepository.findById(employeeId) ;
      EmployeeDto employeeDto = new EmployeeDto(
              employee.get().getId(),
              employee.get().getFirstName(),
              employee.get().getLastName(),
              employee.get().getEmail()
      ) ;
        return employeeDto ;
    }




}


