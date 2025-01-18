package com.microservice.department_service.service;
import com.microservice.department_service.dto.DepartmentDto;

public interface DepartmentService {
     DepartmentDto saveDepartment ( DepartmentDto DepartmentDto) ;
     DepartmentDto getDepatmentByCode (String departmentCode ) ;
}
