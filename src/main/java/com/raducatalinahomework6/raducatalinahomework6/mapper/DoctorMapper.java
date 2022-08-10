package com.raducatalinahomework6.raducatalinahomework6.mapper;

import com.raducatalinahomework6.raducatalinahomework6.dto.DoctorDto;
import com.raducatalinahomework6.raducatalinahomework6.model.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface DoctorMapper {
    DoctorDto todoctorDto (Doctor doctor);
}
