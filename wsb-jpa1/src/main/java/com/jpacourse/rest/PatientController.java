package com.jpacourse.rest;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService service){
        patientService = service;
    }

    @GetMapping("/patient/{id}")
    PatientTO getById(@PathVariable final Long id){
        final PatientTO patient = patientService.getById(id);

        if(patient == null){
            throw new EntityNotFoundException(id);
        }

        return patient;
    }
}
