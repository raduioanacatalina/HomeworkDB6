package com.raducatalinahomework6.raducatalinahomework6.service;

import com.raducatalinahomework6.raducatalinahomework6.exception.NoDoctorException;
import com.raducatalinahomework6.raducatalinahomework6.exception.NoPatientException;
import com.raducatalinahomework6.raducatalinahomework6.exception.NoVisitException;
import com.raducatalinahomework6.raducatalinahomework6.model.Doctor;
import com.raducatalinahomework6.raducatalinahomework6.model.Patient;
import com.raducatalinahomework6.raducatalinahomework6.model.Visit;
import com.raducatalinahomework6.raducatalinahomework6.repository.DoctorRepository;
import com.raducatalinahomework6.raducatalinahomework6.repository.PatientRepository;
import com.raducatalinahomework6.raducatalinahomework6.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final VisitRepository visitRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public void addPatient(Patient patient){
        patientRepository.save(patient);
    }

    public Patient getByCnp(String cnp){
        return patientRepository.getByCnp(cnp);
    }

    public void addDoctor(Integer patientId, Integer doctorId) throws NoPatientException, NoDoctorException {
        Patient p=patientRepository.getById(patientId);
        if (p == null)
            throw new NoPatientException();
        else{
            Doctor d = doctorRepository.getById(doctorId);
            if(d!=null){
                p.setDoctor(d);
                patientRepository.save(p);
            }
            else throw new NoDoctorException();
        }
    }

    public void addVisit(Integer patientId, Integer visitId) throws NoPatientException, NoVisitException {
        Patient p = patientRepository.getById(patientId);
        if (p == null)
            throw new NoPatientException();
        else{
            Visit visit = visitRepository.getById(visitId);
            if(visit!=null){
                p.addVisit(visit);
                patientRepository.save(p);
            }
            else throw new NoVisitException();
        }
    }
}
