package com.okta.springbootvue.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Date;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="MedicalResult")
public class MedicalResult {

    @Id
    @SequenceGenerator(name="medical_result_seq",sequenceName="medical_result_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="medical_result_seq")  
    @Column(name = "MEDICAL_RESULT_ID", unique = true, nullable = true)
    private @NonNull Long medResult_id;

    @Column(name="MED_RESULT")
    private @NonNull String medResult;

    @Column(name="MED_DATE")
    private @NonNull Date medDate;

    @ManyToOne 
    private Doctor doctor; 

    @OneToOne
    private Patient patient;


}