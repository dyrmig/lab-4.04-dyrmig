package com.dyrmig.lab402.controller.impl;

import com.dyrmig.lab402.controller.interfaces.EmployeeController;
import com.dyrmig.lab402.model.Employee;
import com.dyrmig.lab402.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/employees")
public class EmployeeControllerImpl implements EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") Integer id) {
        return employeeRepository.findById(id).get();
    }
    @GetMapping("/")
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
    @GetMapping("/status/{status}")
    public List<Employee> getEmployeeByStatus(@PathVariable(name = "status") String status){
        return employeeRepository.findByStatus(status);
    }
    @GetMapping("/department/{department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable(name = "department") String department){
        return employeeRepository.findByDepartment(department);
    }
}
