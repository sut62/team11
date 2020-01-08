package com.nondt.backend.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Schedule")
public class Schedule {
    @Id    
    @SequenceGenerator(name="schedule_SEQ",sequenceName="schedule_SEQ")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="schedule_SEQ")
    @Column(name="SCHEDULE_Id",unique = true, nullable = true)
    private @NonNull Long scheduleId;


    private @NonNull LocalDate scheduledate;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Profile.class)
    @JoinColumn(name = "ProfileId", unique = true, nullable = true)
    private @NonNull Profile profile_id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Department.class)
    @JoinColumn(name = "DepartmentID", nullable = true)
    private @NonNull Department department_id;
    

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Worktime.class)
    @JoinColumn(name="WORKTIME", insertable = true)
    private Worktime worktime;
   
    



}