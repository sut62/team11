package com.nondt.backend.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Profile {

    @Id
    @SequenceGenerator(name = "Profile_seq", sequenceName = "Profile_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Profile_seq")
    private Long profile_id;

    @NotNull
    private String name;

    @NotNull
    private int age;

    @NotNull
    private String address;

    @NotNull
    private String phone;

    @ManyToOne
    @NotNull
    private Gender gender;
    

    @ManyToOne
    @NotNull
    private Maritalstatus maritalstatus;

    

    @ManyToOne
    @NotNull
    private Department department;

    @ManyToOne
    @NotNull
    private Blood blood;

    public Profile(){}


}
