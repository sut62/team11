package com.okta.cpe.Entity;

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

public class Patient {

    @Id
    @SequenceGenerator(name="patient_seq",sequenceName="patient_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="patient_seq")  

    private  long patient_id;
    private  String name;
    private  String title_name;
    private  String gender;

    public long patient_id() {
        return patient_id;
    }

    public void setPatient_id(long patient_id) {
        this.patient_id = patient_id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String title_name() {
        return title_name;
    }

    public void setTitle_Name(String title_name) {
        this.title_name = title_name;
    }

    public String gender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   

    
}