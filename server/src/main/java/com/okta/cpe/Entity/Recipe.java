package com.nondt.backend.Entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class Recipe {
    @Id
    @SequenceGenerator(name = "Recipe_seq", sequenceName = "Recipe_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Recipe_seq")

    private  Long number;
    private  String amount;
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Medicine.class)
    private Medicine medicine;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity =Type_medicine.class)
    private Type_medicine type_medicine;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity =Physician.class)
    private Physician physician;

    public Long getNumber() {
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


}
