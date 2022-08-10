package com.raducatalinahomework6.raducatalinahomework6.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    String name;
    @OneToMany
    List<Patient> patientList=new ArrayList<>();

    Specialty specialty;

    public void addPatient(Patient patient){
        this.patientList.add(patient);
    }
}
