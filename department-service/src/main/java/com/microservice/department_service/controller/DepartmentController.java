package com.microservice.department_service.controller;

import com.microservice.department_service.dto.DepartmentDto;
import com.microservice.department_service.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService ;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService ;
    }

    //Build save department api
    @PostMapping

    public ResponseEntity<DepartmentDto> saveDepatment (@RequestBody DepartmentDto departmentDto) {
        DepartmentDto saveDepartmentDto = departmentService.saveDepartment(departmentDto) ;
        return new ResponseEntity<>(saveDepartmentDto ,HttpStatus.CREATED) ;
    }

    //get department by Department Code
    @GetMapping("/{department-code}")
    public  ResponseEntity<DepartmentDto> getDepartmentByCode (@PathVariable("department-code") String departmentCode){
       DepartmentDto departmentDto =  departmentService.getDepatmentByCode(departmentCode) ;
       return new ResponseEntity<>(departmentDto, HttpStatus.OK) ;
    }
}
