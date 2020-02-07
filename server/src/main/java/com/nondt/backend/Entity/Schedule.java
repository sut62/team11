package com.nondt.backend.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.*;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

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
   

   @FutureOrPresent
   @NotNull
   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private   LocalDate ScheduleDate;
    
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Profile.class)
    @JoinColumn(name = "ProfileId", insertable = true)
    private  Profile profile_id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Department.class)
    @JoinColumn(name = "DepartmentID", insertable = true)
    private  Department department_id;
    
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Worktime.class)
    @JoinColumn(name="WORKTIME", insertable = true)
    private Worktime worktime;
   
    



}