package com.nondt.backend;
import com.nondt.backend.Entity.*;
import com.nondt.backend.Repository.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class ProfileTests {


    private Validator validator;

    @Autowired
    private  ProfileRepository profileRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    
    @Test
    void b6023973_testProfileNameMustNotBeNull() {
        Profile profile = new Profile();
        profile.setName(null);
        profile.setAge(12);
        profile.setAddress("34");
        profile.setPhone("4848");
        Gender gender = new Gender();
        Maritalstatus maritalstatus = new Maritalstatus();
        Department department = new Department();
        Blood blood = new Blood();
        profile.setGender(gender);
        profile.setMaritalstatus(maritalstatus);
        profile.setDepartment(department);
        profile.setBlood(blood);
        Set<ConstraintViolation<Profile>> result = validator.validate(profile);
        System.out.println(result.size());
        assertEquals(1, result.size());
        ConstraintViolation<Profile> v = result.iterator().next();
        assertEquals("must not be null", v.getMessage());
        assertEquals("name", v.getPropertyPath().toString());
    }


}