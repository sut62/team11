package com.nondt.backend.Entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BookRoom{

    @Id
	@SequenceGenerator(name = "bookroom_seq", sequenceName = "bookroom_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookroom_seq")
    private long bookroom_id;

    private String ceas;


    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private @NonNull Date DateOfBook;
    
    @DateTimeFormat(pattern = "HH-mm-ss")
    private @NonNull Date TimeOfStart;
    
    @DateTimeFormat(pattern = "HH-mm-ss")
    private @NonNull Date TimeOfEnd;

    @Column(name="BookDate")
    private @NonNull Date BookDate;

    @ManyToOne
    private PatientManagement patientManagement;

    @ManyToOne
    private Appointment appointment;

    @ManyToOne
    private Room room;
    
}