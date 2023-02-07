package com.dyrmig.lab402.controller.interfaces;

import com.dyrmig.lab402.controller.dto.EmployeeDepartmentDTO;
import com.dyrmig.lab402.controller.dto.EmployeeStatusDTO;
import com.dyrmig.lab402.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeController {
    Employee getEmployeeById(Integer id);
    List<Employee> getAllEmployee();
    List<Employee> getEmployeeByStatus(String status);
    List<Employee> getEmployeeByDepartment(String department);
    Employee store(Employee employee);
    void updateStatus(Integer employeeId, EmployeeStatusDTO employeeStatusDTO);
    void updateDepartment(Integer employeeId, EmployeeDepartmentDTO employeeDepartmentDTO);
}
