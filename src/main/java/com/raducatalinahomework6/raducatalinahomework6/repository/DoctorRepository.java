package com.raducatalinahomework6.raducatalinahomework6.repository;

import com.raducatalinahomework6.raducatalinahomework6.model.Doctor;
import com.raducatalinahomework6.raducatalinahomework6.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findAll();
    Doctor getById(Integer id);

    List<Doctor> getAllBySpecialty(Specialty specialty);
}
