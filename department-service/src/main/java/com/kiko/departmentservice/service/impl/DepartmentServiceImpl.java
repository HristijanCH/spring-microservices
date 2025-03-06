package com.kiko.departmentservice.service.impl;

import com.kiko.departmentservice.dto.DepartmentDto;
import com.kiko.departmentservice.models.Department;
import com.kiko.departmentservice.repository.DepartmentRepository;
import com.kiko.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository repository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //@todo need to implement mapper for converting into model from dto
        Department department=new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        Department savedDepartment=repository.save(department);

        //@todo need to implement mapper for converting into dto from model
        return new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department=repository.findByDepartmentCode(departmentCode);
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
    }
}
