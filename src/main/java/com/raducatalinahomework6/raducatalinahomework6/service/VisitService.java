package com.raducatalinahomework6.raducatalinahomework6.service;

import com.raducatalinahomework6.raducatalinahomework6.exception.NoPatientException;
import com.raducatalinahomework6.raducatalinahomework6.model.Patient;
import com.raducatalinahomework6.raducatalinahomework6.model.Specialty;
import com.raducatalinahomework6.raducatalinahomework6.model.Visit;
import com.raducatalinahomework6.raducatalinahomework6.repository.PatientRepository;
import com.raducatalinahomework6.raducatalinahomework6.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;


    public List<Visit> getAllVisits(){
        return visitRepository.findAll();
    }

    public void addVisit(Visit visit){
        visitRepository.save(visit);
    }

    public List<Visit> getVisits(String cnp, Specialty specialty) throws NoPatientException {
        Patient p=patientRepository.getByCnp(cnp);
        if (p == null)
            throw new NoPatientException();
        else{
            if (p.getDoctor().getSpecialty() == specialty)
                return p.getVisitList();
        }
        return null;
    }
}
