package com.microservice.employee_service.service.employeeServiceImpl;

import com.microservice.employee_service.dto.ApiResponseDto;
import com.microservice.employee_service.dto.DepartmenntDto;
import com.microservice.employee_service.dto.EmployeeDto;
import com.microservice.employee_service.entity.Employee;
import com.microservice.employee_service.repository.EmployeeRepository;
import com.microservice.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository ;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository =employeeRepository ;
    }

    //Inject WebClient
    @Autowired
    private WebClient webClient ;

    /**
     * Add new Employee
     */
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        //Convert EmployeeDto to Employee entity
        Employee emp = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
      Employee savedEmployee =   employeeRepository.save(emp) ;

      //Convert Employee entity to EmployeeDto
      EmployeeDto empDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName() ,
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        ) ;
        return empDto ;
    }


    /**
     * Get employee by employeeId
     */

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {
       //need to handle error handing using try catch
      Employee employee = employeeRepository.findById(employeeId).get() ;

      DepartmenntDto departmenntDto =  webClient.get().uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
              .retrieve()
              .bodyToMono(DepartmenntDto.class)
              .block() ;

      EmployeeDto employeeDto = new EmployeeDto(
              employee.getId(),
              employee.getFirstName(),
              employee.getLastName(),
              employee.getEmail(),
              employee.getDepartmentCode()
      ) ;

        ApiResponseDto apiResponseDto = new ApiResponseDto(
                employeeDto,
                departmenntDto
        ) ;

        return apiResponseDto ;
    }




}


