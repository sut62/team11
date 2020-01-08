package com.cpe.backend.controller.employee;


import com.cpe.backend.entity.employee_entity.AdminHR;
import com.cpe.backend.repository.employee.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AdminHRController {

    @Autowired
    private final AdminHRRepository adminHRRepository;

    public AdminHRController(AdminHRRepository adminHRRepository) {
        this.adminHRRepository = adminHRRepository;
    }

    @GetMapping("/adminHR/{adminusername}/{adminpassword}")
    public AdminHR Admins(@PathVariable String adminusername, @PathVariable String adminpassword) {
        return adminHRRepository.findAll().stream()
                .filter(s -> s.getAdminHRpassword().equals(adminusername) && s.getAdminHRpassword().equals(adminpassword))
                .collect(Collectors.toList()).get(0);
    }
}