package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.TreatmentType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void testOptimisticLockingOnTheSamePatient() {
        PatientEntity firstRename = patientDao.findOne(3L);
        PatientEntity secondRename = patientDao.findOne(3L);

        firstRename.setFirstName("Success");
        patientDao.update(firstRename);

        secondRename.setFirstName("Throw");

        assertThrows(org.springframework.orm.ObjectOptimisticLockingFailureException.class, () ->
                patientDao.update(secondRename));
    }

    @Test
    @Transactional
    public void testFindByLastNameShouldReturnPatientsWithLastName() {
        String lastName = "Brown";

        List<PatientEntity> patients = patientDao.findByLastName(lastName);

        assertThat(patients).isNotEmpty();
        assertThat(patients.size()).isEqualTo(1);
        assertThat(patients.get(0).getLastName()).isEqualTo(lastName);
    }

    @Test
    @Transactional
    public void findPatientsWithVisitsMoreThanShouldReturnPatientsWithMoreThanXVisits() {
        Integer numberOfVisits = 0;

        List<PatientEntity> patients = patientDao.findPatientsWithVisitsMoreThan(numberOfVisits);

        assertThat(patients).isNotEmpty();

        patients.forEach(patient ->
                assertThat(patient.getVisits().size()).isGreaterThan(numberOfVisits));
    }
}
