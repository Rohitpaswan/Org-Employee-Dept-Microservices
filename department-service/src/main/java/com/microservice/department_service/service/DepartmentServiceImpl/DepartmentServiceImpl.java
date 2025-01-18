package com.microservice.department_service.service.DepartmentServiceImpl;

import com.microservice.department_service.dto.DepartmentDto;
import com.microservice.department_service.entity.Department;
import com.microservice.department_service.repository.DepartmentRepository;
import com.microservice.department_service.service.DepartmentService;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository ;
    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
            this.departmentRepository = departmentRepository ;
    }


    /**
     * save the department data in db
     * */

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //convert Department Dto object to Department JPA Entity
        Department department = new Department(
               departmentDto.getId() ,
                departmentDto.getDepartmentDescription() ,
                departmentDto.getDepartmentName() ,
                departmentDto.getDepartmentCode()
        ) ;
        Department savedDepartment =   departmentRepository.save(department) ;

        //convert Department JPA Entity to Department Dto
        DepartmentDto savedDepartmentDto = new DepartmentDto(
                savedDepartment.getId() ,
                savedDepartment.getDepartmentName() ,
                savedDepartment.getDepartmentDescription() ,
                savedDepartment.getDepartmentCode()
        ) ;

        return savedDepartmentDto;
    }



    /**
     *  Get department by department code
     */

    @Override
    public DepartmentDto getDepatmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode) ;
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId() ,
                department.getDepartmentName() ,
                department.getDepartmentDescription() ,
                department.getDepartmentCode()
        ) ;
        return  departmentDto;
    }


}
