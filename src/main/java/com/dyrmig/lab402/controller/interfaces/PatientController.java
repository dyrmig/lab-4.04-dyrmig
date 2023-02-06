package com.dyrmig.lab402.controller.interfaces;

import com.dyrmig.lab402.model.Patient;

import java.util.List;

public interface PatientController {
    List<Patient> getAllPatients();
    Patient getPatientById(Integer id);
    List<Patient> getPatientsByDoctorDepartment(String department);
    List<Patient> getPatientsByDoctorStatus(String status);
    List<Patient> getPatientsByDOB(String from, String till);

}
