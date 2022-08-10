package com.raducatalinahomework6.raducatalinahomework6.controller;

import com.raducatalinahomework6.raducatalinahomework6.exception.NoDoctorException;
import com.raducatalinahomework6.raducatalinahomework6.exception.NoPatientException;
import com.raducatalinahomework6.raducatalinahomework6.exception.NoVisitException;
import com.raducatalinahomework6.raducatalinahomework6.model.Patient;
import com.raducatalinahomework6.raducatalinahomework6.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/patients/all")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @PostMapping(path="/patients/adddoctor/{patientId}/{doctorId}")
    public void addDoctorP(@PathVariable("patientId") Integer patientId, @PathVariable("doctorId")Integer doctorId) throws NoPatientException, NoDoctorException {
        patientService.addDoctor(patientId,doctorId);
    }

    @PostMapping(path="/patients/addvisit/{patientId}/{visitId}")
    public void addVisit(@PathVariable("patientId") Integer patientId, @PathVariable("visitId")Integer visitId) throws NoPatientException, NoVisitException {
        patientService.addVisit(patientId,visitId);
    }

    @GetMapping("/patients/cnp")
    public Patient getAllByCnp(@RequestParam String cnp){
        return patientService.getByCnp(cnp);
    }

    @PostMapping(path="/patients/addpatient/")
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

}
