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

    
   
}