package com.nondt.backend.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class Recipe {

    @Id
    private  Long number;
    private  String amount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    
    @ManyToOne
    private Profile profile;
    @ManyToOne
    private PatientManagement patientManagement;
    @ManyToOne
    private Medicine medicine;
    @ManyToOne
    private Typemedicine typemedicine;
    public Recipe(){}
        


    /*public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    public String getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    */

}
