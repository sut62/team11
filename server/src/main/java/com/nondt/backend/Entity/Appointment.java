package com.nondt.backend.Entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Appointment{

    @Id
	@SequenceGenerator(name = "appo_seq", sequenceName = "appo_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appo_seq")
    private long appointment_id;

    private String cause;


    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate datetoday;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateap;
    

    @ManyToOne
    private Profile profile;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Appointmenttime appointmenttime;
    
    public Appointment(){}

}