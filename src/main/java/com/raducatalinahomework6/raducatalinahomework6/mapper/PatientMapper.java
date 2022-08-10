package com.raducatalinahomework6.raducatalinahomework6.mapper;

import com.raducatalinahomework6.raducatalinahomework6.dto.PatientDto;
import com.raducatalinahomework6.raducatalinahomework6.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface PatientMapper {
    PatientDto topatientDto (Patient patient);
}
