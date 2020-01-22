package com.nondt.backend.Entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Entity;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Getter
@Setter
public class PatientManagement {

    @Id
    @SequenceGenerator(name="patient_management_seq",sequenceName="patient_management_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="patient_management_seq")  

    private  Long patientManage_id;

    @NotNull
    @Size(min = 3 , max = 100)
    @Pattern(regexp = "[a-zA-Z0-9ก-๙-]*")
    private  String patientManage;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate patientDate;
    

    @ManyToOne 
    private Profile profile; 

    @ManyToOne
    private Department department;

    @OneToOne
    private Patient patient;
    
    public PatientManagement(){}

    public long getPatientManage_id() {
        return patientManage_id;
    }

    public void setPatientManage_id(long patientManage_id) {
        this.patientManage_id = patientManage_id;
    }

    public String getPatientManage() {
        return patientManage;
    }

    public void setPatientManage(String patientManage) {
        this.patientManage = patientManage;
    }

    public LocalDate getPatientDate() {
        return patientDate;
    }

    public void setPatientDate(LocalDate patientDate) {
        this.patientDate = patientDate;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Department getDepartment() { return department; }

    public void setDepartment(Department department) {
        this.department = department;
    }

	
   
}