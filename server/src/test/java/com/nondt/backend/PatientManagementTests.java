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
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class PatientManagementTests {

    private Validator validator;
    @Autowired
    private PatientManagementRepository patientManagementRepository;
    @Autowired
    private  ProfileRepository profileRepository;
    @Autowired
    private  DepartmentRepository departmentRepository;
    @Autowired
    private  PatientRepository patientRepository;

    Profile profile = new Profile();
    Patient patient = new Patient();
    Department department = new Department();
    PatientManagement patientManagement = new PatientManagement();

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        long id =1 ;
        profile = profileRepository.findById(id);
        patient = patientRepository.findById(id);
        department = departmentRepository.findById(id);

    }
    //patientManage(ผลตรวจ) ต้องไม่ใช่ค่าว่าง
    @Test
    void b6008376_testPatientManageMustNotNull() {
        PatientManagement patientManagement = new PatientManagement();


        patientManagement.setPatientManage(null);
        LocalDate date = LocalDate.now();
        patientManagement.setPatientDate(date);
        patientManagement.setProfile(profile);
        patientManagement.setPatient(patient);
        patientManagement.setDepartment(department);

        Set<ConstraintViolation<PatientManagement>> result = validator.validate(patientManagement);
        System.out.println("\n\n\n\n\n testPatientManageMustNotNull Success"+"\n\n\n\n\n");
        assertEquals(1, result.size());
        ConstraintViolation<PatientManagement> v = result.iterator().next();
        assertEquals("must not be null", v.getMessage());
        assertEquals("patientManage", v.getPropertyPath().toString());
    }

    //PatientManage(ผลตรวจ) ต้องไม่ยาวเกิน 100
    @Test
    void b6008376_testPatientManageTooLong() {
        PatientManagement patientManagement = new PatientManagement();


        patientManagement.setPatientManage("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");
        LocalDate date = LocalDate.now();
        patientManagement.setPatientDate(date);
        patientManagement.setProfile(profile);
        patientManagement.setPatient(patient);
        patientManagement.setDepartment(department);

        Set<ConstraintViolation<PatientManagement>> result = validator.validate(patientManagement);
        System.out.println("\n\n\n\n\n testPatientManageTooLong Success"+"\n\n\n\n\n");
        assertEquals(1, result.size());
        ConstraintViolation<PatientManagement> v = result.iterator().next();
        assertEquals("size must be between 3 and 100", v.getMessage());
        assertEquals("patientManage", v.getPropertyPath().toString());
    }

    //PatientManage(ผลตรวจ) ต้องมากกว่า 3 ตัวอักษร
    @Test
    void b6008376_testPatientManageTooShort() {
        PatientManagement patientManagement = new PatientManagement();


        patientManagement.setPatientManage("12");
        LocalDate date = LocalDate.now();
        patientManagement.setPatientDate(date);
        patientManagement.setProfile(profile);
        patientManagement.setPatient(patient);
        patientManagement.setDepartment(department);

        Set<ConstraintViolation<PatientManagement>> result = validator.validate(patientManagement);
        System.out.println("\n\n\n\n\n testPatientManageTooShort Success"+"\n\n\n\n\n");
        assertEquals(1, result.size());
        ConstraintViolation<PatientManagement> v = result.iterator().next();
        assertEquals("size must be between 3 and 100", v.getMessage());
        assertEquals("patientManage", v.getPropertyPath().toString());
    }

    @Test
    void b6008376_testPatientManagePattern() {
        PatientManagement patientManagement = new PatientManagement();


        patientManagement.setPatientManage("test+");
        LocalDate date = LocalDate.now();
        patientManagement.setPatientDate(date);
        patientManagement.setProfile(profile);
        patientManagement.setPatient(patient);
        patientManagement.setDepartment(department);

        Set<ConstraintViolation<PatientManagement>> result = validator.validate(patientManagement);
        System.out.println("\n\n\n\n\n testPatientManageTooShort Success"+"\n\n\n\n\n");
        assertEquals(1, result.size());
        ConstraintViolation<PatientManagement> v = result.iterator().next();
        assertEquals("must match \"[a-zA-Z0-9ก-๙-]*\"", v.getMessage());
        assertEquals("patientManage", v.getPropertyPath().toString());
    }

    //ยังไม่ได้ ติดตรง repository
   /* @Test
    void b6008376_testPatientManageInsertIsOkay() {
        PatientManagement patientManagement = new PatientManagement();


        patientManagement.setPatientManage("1234");
        LocalDate date = LocalDate.now();
        patientManagement.setPatientDate(date);
        patientManagement.setProfile(profile);
        patientManagement.setPatient(patient);
        patientManagement.setDepartment(department);

        patientManagement = patientManagementRepository.saveAndFlush(patientManagement);

        System.out.println("\n\n\n\n\ntestPatientManageInsertIsOkay Success"+"\n\n\n\n\n");
        System.out.println(patientManagement.getPatientManage());
        found = patientManagementRepository.findById(patientManagement.getPatientManage_id());
        assertEquals(patientManagement, found.get());
        
    } */
}

