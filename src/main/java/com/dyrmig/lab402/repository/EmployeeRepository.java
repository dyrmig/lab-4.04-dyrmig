package com.dyrmig.lab402.repository;

import com.dyrmig.lab402.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByStatus(String status);
    List<Employee> findByDepartment(String department);
}
