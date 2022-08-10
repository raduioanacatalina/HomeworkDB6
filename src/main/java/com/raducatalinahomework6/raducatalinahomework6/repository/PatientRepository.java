package com.raducatalinahomework6.raducatalinahomework6.repository;

import com.raducatalinahomework6.raducatalinahomework6.model.Doctor;
import com.raducatalinahomework6.raducatalinahomework6.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAll();
    Patient getById(Integer id);

    List<Patient> getAllByDoctor(Doctor doctor);
    Patient getByCnp(String cnp);
}
