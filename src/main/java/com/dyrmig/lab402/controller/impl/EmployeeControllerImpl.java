package com.dyrmig.lab402.controller.impl;

import com.dyrmig.lab402.controller.dto.EmployeeDepartmentDTO;
import com.dyrmig.lab402.controller.dto.EmployeeStatusDTO;
import com.dyrmig.lab402.controller.interfaces.EmployeeController;
import com.dyrmig.lab402.controller.service.interfaces.EmployeeService;
import com.dyrmig.lab402.model.Employee;
import com.dyrmig.lab402.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/employees")
public class EmployeeControllerImpl implements EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;
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
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee store(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PatchMapping("/{employeeId}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable Integer employeeId, @RequestBody EmployeeStatusDTO employeeStatusDTO) {
        employeeService.updateStatus(employeeId, employeeStatusDTO);
    }
    @PatchMapping("/{employeeId}/department")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDepartment(@PathVariable Integer employeeId, @RequestBody EmployeeDepartmentDTO employeeDepartmentDTO) {
        employeeService.updateDepartment(employeeId, employeeDepartmentDTO);
    }
}
