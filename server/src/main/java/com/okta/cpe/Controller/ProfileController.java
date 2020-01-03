package com.okta.cpe.Controller;

import com.okta.cpe.Entity.*;
import com.okta.cpe.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ProfileController {

    @Autowired
    private final ProfileRepository profileRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private MaritalstatusRepository maritalstatusRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private BloodRepository bloodRepository;


    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping("/profile")
    public Collection<Profile> Profile() {
        return profileRepository.findAll().stream().collect(Collectors.toList());
    }

}