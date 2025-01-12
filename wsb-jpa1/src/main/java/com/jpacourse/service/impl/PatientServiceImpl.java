package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;
    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao) {patientDao = pPatientDao;}

    @Override
    public PatientTO findById(Long id)
    {
        final PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTO(entity);
    }
}
