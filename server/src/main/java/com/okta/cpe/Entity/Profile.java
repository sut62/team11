package com.okta.cpe.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@ToString

@Table(name = "Profile")
public class Profile {

    @Id
    @SequenceGenerator(name = "Profile_seq", sequenceName = "Profile_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Profile_seq")
    @Column(name = "ProfileId", unique = true, nullable = true)
    private @NonNull Long profile_id;

    @Column(name = "Profile")
    private @NonNull String name;
    private @NonNull Long age;
    private @NonNull String address;


    @ManyToOne
    @JoinColumn( unique = true, nullable = true)
    private Gender gender;
    

    @ManyToOne
    @JoinColumn(name = "MaritalstatusID",  nullable = true)
    private Maritalstatus maritalstatus;

    @ManyToOne
    @JoinColumn(name = "DepartmentId", insertable = true)
    private Department department;

    

}
