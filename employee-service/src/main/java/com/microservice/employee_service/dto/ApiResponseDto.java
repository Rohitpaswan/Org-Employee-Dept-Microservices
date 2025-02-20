package com.microservice.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ApiResponseDto {
    private EmployeeDto employee ;
    private DepartmenntDto departmenn ;
}
