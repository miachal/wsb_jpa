package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.entity.PatientEntity;

public class PatientMapper {

    public static PatientTO mapToTO(final PatientEntity patientEntity) {
        if (patientEntity == null)
        {
            return null;
        }
        final PatientTO patientTo = new PatientTO();
        patientTo.setId(patientEntity.getId());
        patientTo.setFirstName(patientEntity.getFirstName());
        patientTo.setLastName(patientEntity.getLastName());
        patientTo.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTo.setEmail(patientEntity.getEmail());
        patientTo.setPatientNumber(patientEntity.getPatientNumber());
        patientTo.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTo.setAddress(AddressMapper.mapToTO(patientEntity.getAddress()));
        patientTo.setVisits(VisitMapper.mapToTOs(patientEntity.getVisits()));
        patientTo.setIsMale(patientEntity.getIsMale());
        return patientTo;
    }
}
