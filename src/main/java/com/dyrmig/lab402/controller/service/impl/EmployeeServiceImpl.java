package com.dyrmig.lab402.controller.service.impl;

import com.dyrmig.lab402.controller.dto.EmployeeDepartmentDTO;
import com.dyrmig.lab402.controller.dto.EmployeeStatusDTO;
import com.dyrmig.lab402.controller.service.interfaces.EmployeeService;
import com.dyrmig.lab402.model.Employee;
import com.dyrmig.lab402.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void updateStatus(Integer employeeId, EmployeeStatusDTO employeeStatusDTO) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if(!optionalEmployee.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not found");
        }
        optionalEmployee.get().setStatus(employeeStatusDTO.getStatus());
        employeeRepository.save(optionalEmployee.get());
    }

    @Override
    public void updateDepartment(Integer employeeId, EmployeeDepartmentDTO employeeDepartmentDTO) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if(!optionalEmployee.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not found");
        }
        optionalEmployee.get().setDepartment(employeeDepartmentDTO.getDepartment());
        employeeRepository.save(optionalEmployee.get());
    }
}
