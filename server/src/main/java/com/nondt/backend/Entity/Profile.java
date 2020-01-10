package com.nondt.backend.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
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

    private String name;
    private int age;
    private String address;


    @ManyToOne
    private Gender gender;
    

    @ManyToOne
    private Maritalstatus maritalstatus;

    

    @ManyToOne
    private Department department;

    @ManyToOne
    private Blood blood;

    public Profile(){}
}
