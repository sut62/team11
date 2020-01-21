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
public class AppointmentTest {


    private Validator validator;

    @Autowired
    private  AppointmentRepository appointmentRepository;
    @Autowired
    private  ProfileRepository profileRepository;
    @Autowired
    private  PatientRepository patientRepository;
    @Autowired
    private  AppointmenttimeRepository appointmenttimeRepository;

    Profile profile = new Profile();
    Patient patient = new Patient();
    Appointmenttime appointmenttime = new Appointmenttime();

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        long id =1 ;
        profile = profileRepository.findById(id);
        patient = patientRepository.findById(id);
        appointmenttime = appointmenttimeRepository.findById(id);
    }
    // Cause Complete
    @Test
    void testCauseOK() {
        Appointment appointment = new Appointment();


        appointment.setCause("1234");
        LocalDate date = LocalDate.now();
        appointment.setDatetoday(date);
        appointment.setDateap(date);
        appointment.setProfile(profile);
        appointment.setPatient(patient);
        appointment.setAppointmenttime(appointmenttime);
        appointment = appointmentRepository.saveAndFlush(appointment);
        System.out.println("\n\n\n\n\ntestCauseOK Success"+"\n\n\n\n\n");
        System.out.println(appointment.getCause());
        Optional<Appointment> found = appointmentRepository.findById(appointment.getAppointment_id());
        assertEquals("1234", found.get().getCause());
    }

    // Cause Null
    @Test
    void b6018153_testCauseMustNotBeNull() {
        Appointment appointment = new Appointment();

        appointment.setCause(null);
        LocalDate date = LocalDate.now();
        appointment.setDatetoday(date);
        appointment.setDateap(date);
        appointment.setProfile(profile);
        appointment.setPatient(patient);
        appointment.setAppointmenttime(appointmenttime);
        Set<ConstraintViolation<Appointment>> result = validator.validate(appointment);
        System.out.println("\n\n\n\n\ntestCauseMustNotBeNull Success"+"\n\n\n\n\n");
        assertEquals(1, result.size());
        ConstraintViolation<Appointment> v = result.iterator().next();
        assertEquals("must not be null", v.getMessage());
        assertEquals("cause", v.getPropertyPath().toString());
    }

    //Test Cause สั้นเกิน
    @Test
    void b6018153_testCauseShort() {
        Appointment appointment = new Appointment();
        appointment.setCause("12");
        LocalDate date = LocalDate.now();
        appointment.setDatetoday(date);
        appointment.setDateap(date);
        appointment.setProfile(profile);
        appointment.setPatient(patient);
        appointment.setAppointmenttime(appointmenttime);

        Set<ConstraintViolation<Appointment>> result = validator.validate(appointment);
        System.out.println("\n\n\n\n\ntestCauseShort Success"+"\n\n\n\n\n");
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Appointment> v = result.iterator().next();
        assertEquals("must match \"\\w{3,100}\"", v.getMessage());
        assertEquals("cause", v.getPropertyPath().toString());
    }

    //Test Cause ยาวเกิน
    @Test
    void b6018153_testCauseOver() {
        Appointment appointment = new Appointment();
        appointment.setCause("12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc" +
                "12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc" +
                "12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc" +
                "12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc" +
                "12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc" +
                "12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc" +
                "12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc12sasacasc4as6d546a5sc46a5s4c56as4c65a46s5cascasc");

        LocalDate date = LocalDate.now();
        appointment.setDatetoday(date);
        appointment.setDateap(date);
        appointment.setProfile(profile);
        appointment.setPatient(patient);
        appointment.setAppointmenttime(appointmenttime);

        Set<ConstraintViolation<Appointment>> result = validator.validate(appointment);
        System.out.println("\n\n\n\n\ntestCauseOver Success"+"\n\n\n\n\n");
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Appointment> v = result.iterator().next();
        assertEquals("must match \"\\w{3,100}\"", v.getMessage());
        assertEquals("cause", v.getPropertyPath().toString());
    }



}