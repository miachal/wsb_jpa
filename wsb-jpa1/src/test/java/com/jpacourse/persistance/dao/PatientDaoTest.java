package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.TreatmentType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    @Transactional
    public void testAddNewVisit() {
        Long patientId = 1L;
        Long doctorId = 1L;
        LocalDateTime date = LocalDateTime.of(2025, 1, 12, 13, 31);
        String visitDescription = "test visit";
        String treatmentDescription = "test treatment";
        TreatmentType treatmentType = TreatmentType.EKG;

        VisitEntity newVisit = patientDao.addNewVisit(patientId, doctorId, date, visitDescription, treatmentDescription, treatmentType);

        assertThat(newVisit).isNotNull();
        assertThat(newVisit.getDescription()).isEqualTo(visitDescription);
        assertThat(newVisit.getPatient().getId()).isEqualTo(patientId);
        assertThat(newVisit.getDoctor().getId()).isEqualTo(doctorId);

        assertThat(newVisit.getMedicalTreatments().get(0).getDescription()).isEqualTo(treatmentDescription);
        assertThat(newVisit.getMedicalTreatments().get(0).getType()).isEqualTo(treatmentType);
    }

}
