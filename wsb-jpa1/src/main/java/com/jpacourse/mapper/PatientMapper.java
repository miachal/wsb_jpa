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
        patientTo.setAddress(patientEntity.getAddress());
        patientTo.setVisits(patientEntity.getVisits());
        patientTo.setIsMale(patientEntity.getIsMale());
        return patientTo;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        if(patientTO == null)
        {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setAddress(patientTO.getAddress());
        patientEntity.setVisits(patientTO.getVisits());
        patientEntity.setIsMale(patientTO.getIsMale());
        return patientEntity;
    }
}
