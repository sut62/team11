package com.okta.cpe.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Entity
public class Typemedicine {
    @Id
    @SequenceGenerator(name = "Typemedicine_SEQ", sequenceName = "Typemedicine_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Typemedicine_SEQ")
    private  Long typemedicine_id;
    private  String typemedicine_name;

    public Long getTypemedicine_id() {
        return typemedicine_id;
    }
    public void setTypemedicine_id(Long typemedicine_id) {
        this.typemedicine_id = typemedicine_id;
    }

    public String getTypemedicine_name() {
        return typemedicine_name;
    }
    public void setTypemedicine_name(String typemedicine_name) {
        this.typemedicine_name = typemedicine_name;
    }
}