package com.okta.springbootvue.entity;

import lombok.Data;
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
@Table(name="Appointment")
public class MedicalResult {

    @Id
    @SequenceGenerator(name="appointment_seq",sequenceName="appointment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="appointment_seq")
    @Column(name = "APPOINTMENT_ID", unique = true, nullable = true)
    private @NonNull Long appointment_id;

    @Column(name="APPOINT_TIME")
    private @NonNull String appointTime;

    @Column(name="APPOINT_DATE")
    private @NonNull Date appointDate;

    @ManyToOne
    private Doctor doctor;

    @OneToOne
    private Patient patient;

    @ManyToOne
    private department department;

}