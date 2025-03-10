package com.kiko.employeeservice.service;

import com.kiko.employeeservice.dto.ApiResponseDto;
import com.kiko.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ApiResponseDto getEmployeeById(Long id);
}
