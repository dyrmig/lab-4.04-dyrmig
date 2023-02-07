package com.dyrmig.lab402.controller.service.impl;

import com.dyrmig.lab402.controller.service.interfaces.PatientService;
import com.dyrmig.lab402.model.Employee;
import com.dyrmig.lab402.model.Patient;
import com.dyrmig.lab402.repository.EmployeeRepository;
import com.dyrmig.lab402.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;
    private EmployeeRepository employeeRepository;
    @Override
    public void update(Integer patientId, Patient patient) {
        if(!patientRepository.findById(patientId).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"patient not found");
        }
        patient.setPatientId(patientId);
        patientRepository.save(patient);
    }
}
