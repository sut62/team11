package com.nondt.backend.Entity;
import lombok.*;

import javax.persistence.Id;

import javax.persistence.SequenceGenerator;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Entity;





@Entity
@Getter
@Setter
public class Patient {

    @Id
    @SequenceGenerator(name="patient_seq",sequenceName="patient_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="patient_seq")  

    private  long patient_id;
    private  String name;
    private  String title_name;
    private  String gender;
    private  int age;

   public Patient(){}

    
}