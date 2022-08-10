package com.raducatalinahomework6.raducatalinahomework6.controller;

import com.raducatalinahomework6.raducatalinahomework6.exception.NoDoctorException;
import com.raducatalinahomework6.raducatalinahomework6.exception.NoPatientException;
import com.raducatalinahomework6.raducatalinahomework6.model.Doctor;
import com.raducatalinahomework6.raducatalinahomework6.model.Specialty;
import com.raducatalinahomework6.raducatalinahomework6.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DoctorController {
    final DoctorService doctorService;

    @GetMapping("/doctors/all")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @PostMapping(path="/doctors/addpatient/{doctorId}/{patientId}")
    public void addPatient(@PathVariable("doctorId")Integer doctorId, @PathVariable("patientId") Integer patientId) throws NoDoctorException, NoPatientException {
        doctorService.addPatient(doctorId, patientId);
    }

    @GetMapping("/doctors/specialty")
    public List<Doctor> getAllBySpecialty(@RequestParam Specialty specialty){
        return doctorService.getAllBySpecialty(specialty);
    }

    @PostMapping(path="/doctors/adddoctor/")
    public void addDoctor(@RequestBody Doctor doctor) {
        doctorService.addDoctor(doctor);
    }
}
