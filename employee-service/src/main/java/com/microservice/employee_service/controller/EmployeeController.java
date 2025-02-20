package com.microservice.employee_service.controller;

import com.microservice.employee_service.dto.ApiResponseDto;
import com.microservice.employee_service.dto.EmployeeDto;
import com.microservice.employee_service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/employee/")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeSerivce){
        this.employeeService =employeeSerivce ;

    }

    /**
     * api for add new employee in database
     */
    @PostMapping("add-employee")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto saveEmployeeDto = employeeService.saveEmployee(employeeDto) ;
        return new ResponseEntity<>(saveEmployeeDto , HttpStatus.CREATED) ;
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable Long employeeId ) {
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId) ;
        return  new ResponseEntity<>(apiResponseDto, HttpStatus.OK) ;
    }

}
