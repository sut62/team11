package com.nondt.backend.Controller;

import com.nondt.backend.Entity.*;
import com.nondt.backend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class PatientManagementController {

    @Autowired
    private PatientManagementRepository patientManagementRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private DepartmentRepository departmentRepository;


    @GetMapping("/patient")
    public Collection<Patient> patients() {
        return patientRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/patientmanage")
    public Collection<PatientManagement> patientmanages() {
        return patientManagementRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/patientmanagement/{profileSelect}/{departSelect}/{title}/{name}/{genSelect}/{age}/{pati}/{date}")
    public void newPatientManagement(

            @PathVariable long profileSelect, @PathVariable long departSelect, @PathVariable String title,
            @PathVariable String name, @PathVariable String genSelect, @PathVariable String age,
            @PathVariable String pati ,@PathVariable String date) 
                  {

                Patient patient = new Patient();
                patient.setTitle_name(title);
                patient.setName(name);
                patient.setGender(genSelect);
                patient.setAge(Integer.valueOf(age));
                patientRepository.save(patient);

                Department department = departmentRepository.findById(departSelect);
                Profile profile = profileRepository.findById(profileSelect);
                PatientManagement patientManagement = new PatientManagement();
                patientManagement.setPatient(patient);
                patientManagement.setPatientManage(pati);
                patientManagement.setDepartment(department);
                patientManagement.setProfile(profile);
                String[] b = date.split(" ");
            int year = Integer.valueOf(b[3]);

            int day = Integer.valueOf(b[2]);
            int month = 1 ;

            if(b[1].equalsIgnoreCase("Jan")){ month = 1;}else if(b[1].equalsIgnoreCase("Feb")){ month = 2;}
            else if(b[1].equalsIgnoreCase("Mar")){ month = 3;}else if(b[1].equalsIgnoreCase("Mar")){ month = 4;}
            else if(b[1].equalsIgnoreCase("May")){ month = 5;}else if(b[1].equalsIgnoreCase("Jun")){ month = 6;}
            else if(b[1].equalsIgnoreCase("Jul")){ month = 7;}else if(b[1].equalsIgnoreCase("Aug")){ month = 8;}
            else if(b[1].equalsIgnoreCase("Sep")){ month = 9;}else if(b[1].equalsIgnoreCase("Oct")){ month = 10;}
            else if(b[1].equalsIgnoreCase("Nov")){ month = 11;}else if(b[1].equalsIgnoreCase("Dec")){ month = 12;}


            LocalDate localDate = LocalDate.of(year,month,day);
                patientManagement.setPatientDate(localDate);
                patientManagementRepository.save(patientManagement);
    }

}