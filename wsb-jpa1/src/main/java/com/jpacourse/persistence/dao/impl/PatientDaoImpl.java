package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.TreatmentType;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @Override
    public VisitEntity addNewVisit(Long patientId, Long doctorId, LocalDateTime date, String visitDescription, String treatmentDescription, TreatmentType treatmentType) {
        PatientEntity patientEntity = entityManager.find(PatientEntity.class, patientId);
        DoctorEntity doctorEntity = entityManager.find(DoctorEntity.class, doctorId);

        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setTime(date);
        visitEntity.setDescription(visitDescription);
        visitEntity.setDoctor(doctorEntity);
        visitEntity.setPatient(patientEntity);

        MedicalTreatmentEntity medicalTreatment = new MedicalTreatmentEntity();
        medicalTreatment.setDescription(treatmentDescription);
        medicalTreatment.setType(treatmentType);
        medicalTreatment.setVisit(visitEntity);

        visitEntity.getMedicalTreatments().add(medicalTreatment);

        patientEntity.getVisits().add(visitEntity);

        update(patientEntity);

        return visitEntity;
    }

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery("SELECT patient FROM PatientEntity patient WHERE lastName = :lastName",
                PatientEntity.class).setParameter("lastName", lastName).getResultList();
    }

    @Override
    public List<VisitEntity> findVisitsByPatientId(Long id) {
        return entityManager.createQuery("SELECT visit FROM VisitEntity visit JOIN FETCH visit.patient patient WHERE patient.id = :id",
                        VisitEntity.class).setParameter("id", id).getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithVisitsMoreThan(Integer number) {
        return entityManager.createQuery("SELECT patient FROM PatientEntity patient JOIN patient.visits visits GROUP BY patient HAVING CAST(COUNT(visits) AS int) > :number",
                        PatientEntity.class).setParameter("number", number).getResultList();
    }

    @Override
    public List<PatientEntity> findPatientByGender(Boolean isMale) {
        return entityManager.createQuery("SELECT patient FROM PatientEntity patient WHERE patient.isMale = :isMale",
                        PatientEntity.class).setParameter("isMale", isMale).getResultList();
    }

    @Override
    public PatientEntity findOne(Long id){
        return entityManager.find(getDomainClass(), id, LockModeType.OPTIMISTIC);
    }
}
