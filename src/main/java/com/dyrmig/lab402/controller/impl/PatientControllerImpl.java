package com.dyrmig.lab402.controller.impl;

import com.dyrmig.lab402.controller.interfaces.PatientController;
import com.dyrmig.lab402.controller.service.interfaces.PatientService;
import com.dyrmig.lab402.model.Patient;
import com.dyrmig.lab402.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/patients")
public class PatientControllerImpl implements PatientController {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;
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

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient store(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @PutMapping("/{patientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer patientId, @RequestBody Patient patient) {
        patientService.update(patientId, patient);
    }
}
