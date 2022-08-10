package com.raducatalinahomework6.raducatalinahomework6.dto;

import com.raducatalinahomework6.raducatalinahomework6.model.Doctor;
import com.raducatalinahomework6.raducatalinahomework6.model.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    String name;
    Specialty specialty;

    public DoctorDto(Doctor doctor){
        this.name=doctor.getName();
        this.specialty=doctor.getSpecialty();
    }

}
