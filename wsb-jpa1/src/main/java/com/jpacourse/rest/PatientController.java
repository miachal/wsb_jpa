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
    PatientTO findById(@PathVariable final Long id){
        final PatientTO patient = patientService.findById(id);

        if(patient == null){
            throw new EntityNotFoundException(id);
        }

        return patient;
    }
}
