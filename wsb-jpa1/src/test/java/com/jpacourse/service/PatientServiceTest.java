package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientDao patientDao;

    private PatientServiceImpl service;

    @BeforeEach
    public void setUp() {
        service = new PatientServiceImpl(patientDao);
    }

    @Test
    @Transactional
    public void testFindByIdShouldReturnPatientTO() {
        Long id = 1L;

        PatientTO result = service.findById(id);

        assertThat(result).isNotNull();
        assertThat(result.getIsMale()).isEqualTo(false);
    }

    @Test
    @Transactional
    public void testFindByIdShouldReturnNullIfPatientNotFound() {
        Long id = 9999L;

        PatientTO result = service.findById(id);

        assertThat(result).isNull();
    }
}
