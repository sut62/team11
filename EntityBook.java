package com.cpe.springbootvue;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@NoArgsConstructor
@Table(name="EntityBook")
public class EntityBook {

    @Id
    @SequenceGenerator(name="EntityBook",sequenceName="EntityBook")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EntityBook")
    @Column(name = "ID_Book", unique = true, nullable = true)
    private @NonNull Long ID_Book;

    @DateTimeFormat(pattern = "dd-M-yyyy hh:mm:ss")
    private @NonNull Date StartBookDate;

    @DateTimeFormat(pattern = "dd-M-yyyy hh:mm:ss")
    private @NonNull Date EndBookDate;
  
    private @NonNull String SAddress_of_Staff;

    @Column(name="BookDate ")
    private @NonNull Date BookDate;
    

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Room.class)
    @JoinColumn(name = "ID_Room", insertable = true)
    private Room Room;

}