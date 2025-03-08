package com.kiko.employeeservice.service.impl;

import com.kiko.employeeservice.dto.EmployeeDto;
import com.kiko.employeeservice.models.Employee;
import com.kiko.employeeservice.repository.EmployeeRepository;
import com.kiko.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        //@todo need to implement mapper for employee to dto and vice versa
        Employee employee=new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
        Employee savedEmployee= repository.save(employee);
        return new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail()
        );
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee=repository.findById(id).get();
        //@todo need to implement mapper for employee to dto and vice versa
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
}
