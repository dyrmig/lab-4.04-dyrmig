package com.dyrmig.lab402.controller.impl;

import com.dyrmig.lab402.controller.interfaces.PatientController;
import com.dyrmig.lab402.model.Patient;
import com.dyrmig.lab402.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/patients")
public class PatientControllerImpl implements PatientController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable(name = "id") Integer id) {
        return patientRepository.findById(id).get();
    }
    @GetMapping("/employee/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable(name = "department") String department) {
        return patientRepository.getPatientsByDoctorDepartment(department);
    }
    @GetMapping("/employee/status/{status}")
    public List<Patient> getPatientsByDoctorStatus(@PathVariable(name = "status") String status) {
        return patientRepository.getPatientsByDoctorStatus(status);
    }
    @GetMapping("/dob/{from}/{till}")
    public List<Patient> getPatientsByDOB(@PathVariable(name = "from") String from, @PathVariable(name = "till") String till) {
        return patientRepository.getPatientsByDOB(from, till);
    }
}
