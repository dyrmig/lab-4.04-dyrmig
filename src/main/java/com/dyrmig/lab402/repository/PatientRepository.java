package com.dyrmig.lab402.repository;

import com.dyrmig.lab402.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query("SELECT p FROM Patient p JOIN Employee e ON p.admittedBy = e.employeeId WHERE e.department = :department")
    List<Patient> getPatientsByDoctorDepartment(@Param("department") String department);
    @Query("SELECT p FROM Patient p JOIN Employee e ON p.admittedBy = e.employeeId WHERE e.status = :status")
    List<Patient> getPatientsByDoctorStatus(@Param("status") String status);
    @Query("SELECT p FROM Patient p WHERE p.dateOfBirth BETWEEN :from AND :till")
    List<Patient> getPatientsByDOB(@Param("from") String from, @Param("till") String till);
}
