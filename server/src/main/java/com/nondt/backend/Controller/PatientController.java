package com.nondt.backend.Controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.nondt.backend.Entity.Patient;
import com.nondt.backend.Repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class PatientController {


    @Autowired
    private PatientRepository patientRepository;



    @GetMapping("/patient")
    public Collection<Patient> patients() {
        return patientRepository.findAll().stream().collect(Collectors.toList());
    }



}