package com.okta.springbootvue.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;

import java.util.Date;



@Entity

public class PatientManagement {

    @Id
    @SequenceGenerator(name="patient_management_seq",sequenceName="patient_management_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="patient_management_seq")  

    private  Long patientManage_id;
    private  String patientManage;
    private  Date patientDate;

    @ManyToOne 
    private Profile profile; 

    @OneToOne
    private Patient patient;

  

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
    
}