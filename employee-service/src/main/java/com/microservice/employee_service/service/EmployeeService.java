package com.microservice.employee_service.service;

import com.microservice.employee_service.dto.ApiResponseDto;
import com.microservice.employee_service.dto.EmployeeDto;



public interface EmployeeService {
     EmployeeDto saveEmployee(EmployeeDto employeeDto) ;
     ApiResponseDto getEmployeeById(Long employeeId) ;

}
