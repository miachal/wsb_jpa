package com.jpacourse.dto;

import java.time.LocalDateTime;
import java.util.List;

public class VisitTO {
    private Long id;
    private LocalDateTime time;
    private String doctorName;
    private List<String> medicalTreatmentTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public List<String> getMedicalTreatmentTypes() {
        return medicalTreatmentTypes;
    }

    public void setMedicalTreatmentTypes(List<String> medicalTreatmentTypes) {
        this.medicalTreatmentTypes = medicalTreatmentTypes;
    }
}
