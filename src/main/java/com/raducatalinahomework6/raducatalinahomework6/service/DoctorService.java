package com.raducatalinahomework6.raducatalinahomework6.service;

import com.raducatalinahomework6.raducatalinahomework6.exception.NoDoctorException;
import com.raducatalinahomework6.raducatalinahomework6.exception.NoPatientException;
import com.raducatalinahomework6.raducatalinahomework6.model.Doctor;
import com.raducatalinahomework6.raducatalinahomework6.model.Patient;
import com.raducatalinahomework6.raducatalinahomework6.model.Specialty;
import com.raducatalinahomework6.raducatalinahomework6.repository.DoctorRepository;
import com.raducatalinahomework6.raducatalinahomework6.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public void addPatient(Integer doctorId, Integer patientId) throws NoDoctorException, NoPatientException {
        Doctor d = doctorRepository.getById(doctorId);
        if (d == null)
            throw new NoDoctorException();
        else{
            Patient p=patientRepository.getById(patientId);
            if(p!=null){
                d.addPatient(p);
                doctorRepository.save(d);
            }
            else throw new NoPatientException();
        }
    }
    public void addDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public List<Doctor> getAllBySpecialty(Specialty specialty){
        return doctorRepository.getAllBySpecialty(specialty);
    }
}
