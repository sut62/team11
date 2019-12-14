package com.nondt.backend.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Entity
public class Medicine {
    @Id
    @SequenceGenerator(name = "Medicine_SEQ", sequenceName = "Medicine_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Medicine_SEQ")
    private  Long medicin_id;
    private  String medicin_name;

    public Long getMedicine_id() {
        return medicin_id;
    }
    public void setMedicine_id(Long medicin_id) {
        this.medicin_id = medicin_id;
    }

    public String getMedicine_name() {
        return medicin_name;
    }
    public void setMedicine_name(String medicin_name) {
        this.medicin_name = medicin_name;
    }
}