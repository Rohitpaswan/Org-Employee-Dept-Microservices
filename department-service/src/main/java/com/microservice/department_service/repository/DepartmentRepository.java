package com.microservice.department_service.repository;


import com.microservice.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department , Long> {

    /* Find Department by its code */
    public Department findByDepartmentCode(String departmentCode);
}
