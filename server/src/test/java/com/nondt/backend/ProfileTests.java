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


@DataJpaTest
public class ProfileTests {


    private Validator validator;

    @Autowired
    private  ProfileRepository profileRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private MaritalstatusRepository maritalstatusRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private BloodRepository bloodRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void b6023973_testProfileInsertOK() {
        Profile profile = new Profile();
        profile.setName("suwanan poedpong");
        profile.setAge(12);
        profile.setAddress("45140 roi-et");
        profile.setPhone("1234567890");
        Department department = departmentRepository.findById(1);
        Gender gender = genderRepository.findById(1);
        Blood blood = bloodRepository.findById(1);
        Maritalstatus maritalstatus = maritalstatusRepository.findById(1);
        profile.setGender(gender);
        profile.setMaritalstatus(maritalstatus);
        profile.setDepartment(department);
        profile.setBlood(blood);

        profile = profileRepository.saveAndFlush(profile);
        // เรียก borrowedBike ที่พึ่งบันทึกขึ้นมาดู
        Optional<Profile> found = profileRepository.findById(profile.getProfile_id());
        // assert check
        assertEquals(profile, found.get());
    }
    
    @Test
    void b6023973_Profile_testNameMustNotBeNull() {
        Profile profile = new Profile();
        profile.setName(null);
        profile.setAge(12);
        profile.setAddress("45140 roi-et");
        profile.setPhone("1234567890");
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

    @Test
    void B6023973_Profile_testAddressSize()  {
        Profile profile = new Profile();
        profile.setName("ooy ooy");
        profile.setAge(12);
        profile.setAddress("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");
        profile.setPhone("1234567890");
        Department department = departmentRepository.findById(1);
        Gender gender = genderRepository.findById(1);
        Blood blood = bloodRepository.findById(1);
        Maritalstatus maritalstatus = maritalstatusRepository.findById(1);
        profile.setGender(gender);
        profile.setMaritalstatus(maritalstatus);
        profile.setDepartment(department);
        profile.setBlood(blood);
        Set<ConstraintViolation<Profile>> result = validator.validate(profile);

        // // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Profile> v = result.iterator().next();
        assertEquals("size must be between 0 and 80", v.getMessage());
        assertEquals("address", v.getPropertyPath().toString());
    }
    
    @Test
    void B6023973_Profile_testPhoneNotePattern() {
        Profile profile = new Profile();
        profile.setName("suwanan poedpong");
        profile.setAge(12);
        profile.setAddress("45140 roi-et");
        profile.setPhone("a234567890");
        Department department = departmentRepository.findById(1);
        Gender gender = genderRepository.findById(1);
        Blood blood = bloodRepository.findById(1);
        Maritalstatus maritalstatus = maritalstatusRepository.findById(1);
        profile.setGender(gender);
        profile.setMaritalstatus(maritalstatus);
        profile.setDepartment(department);
        profile.setBlood(blood);

        Set<ConstraintViolation<Profile>> result = validator.validate(profile);
        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Profile> v = result.iterator().next();
        assertEquals("must match \"\\d{10}\"", v.getMessage());
        assertEquals("phone", v.getPropertyPath().toString());
    }

    @Test
    void B6023973_Profile_testNameNotePattern() {
        Profile profile = new Profile();
        profile.setName("suwanan+poedpong");
        profile.setAge(12);
        profile.setAddress("45140 roi-et");
        profile.setPhone("1234567890");
        Department department = departmentRepository.findById(1);
        Gender gender = genderRepository.findById(1);
        Blood blood = bloodRepository.findById(1);
        Maritalstatus maritalstatus = maritalstatusRepository.findById(1);
        profile.setGender(gender);
        profile.setMaritalstatus(maritalstatus);
        profile.setDepartment(department);
        profile.setBlood(blood);

        Set<ConstraintViolation<Profile>> result = validator.validate(profile);
        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Profile> v = result.iterator().next();
        assertEquals("must match \"[a-zA-Zก-ฮ ]*\"", v.getMessage());
        assertEquals("name", v.getPropertyPath().toString());
    }

    @Test
    void B6023973_Profile_testAgeNotePositive() {
        Profile profile = new Profile();
        profile.setName("suwanan poedpong");
        profile.setAge(-12);
        profile.setAddress("45140 roi-et");
        profile.setPhone("1234567890");
        Department department = departmentRepository.findById(1);
        Gender gender = genderRepository.findById(1);
        Blood blood = bloodRepository.findById(1);
        Maritalstatus maritalstatus = maritalstatusRepository.findById(1);
        profile.setGender(gender);
        profile.setMaritalstatus(maritalstatus);
        profile.setDepartment(department);
        profile.setBlood(blood);

        Set<ConstraintViolation<Profile>> result = validator.validate(profile);
        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Profile> v = result.iterator().next();
        assertEquals("must be greater than 0", v.getMessage());
        assertEquals("age", v.getPropertyPath().toString());
    }




}