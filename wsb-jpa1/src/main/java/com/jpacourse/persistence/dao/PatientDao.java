package com.jpacourse.persistence.dao;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.TreatmentType;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    VisitEntity addNewVisit(Long patientId, Long doctorId, LocalDateTime date, String visitDescription,
                            String treatmentDescription, TreatmentType treatmentType);

    List<PatientEntity> findByLastName(String lastName);

    List<VisitEntity> findVisitsByPatientId(Long patientId);

    List<PatientEntity> findPatientsWithVisitsMoreThan(Integer number);

    List<PatientEntity> findPatientByGender(Boolean isMale);
}
