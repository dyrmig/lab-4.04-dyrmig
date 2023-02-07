package com.dyrmig.lab402.controller.service.interfaces;

import com.dyrmig.lab402.controller.dto.EmployeeDepartmentDTO;
import com.dyrmig.lab402.controller.dto.EmployeeStatusDTO;

public interface EmployeeService {
    void updateStatus(Integer employeeId, EmployeeStatusDTO employeeStatusDTO);
    void updateDepartment(Integer employeeId, EmployeeDepartmentDTO employeeDepartmentDTO);
}
