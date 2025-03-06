package com.kiko.departmentservice.repository;

import com.kiko.departmentservice.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepartmentCode(String s);
}
