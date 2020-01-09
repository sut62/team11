package com.nondt.backend.Controller;

import com.nondt.backend.Entity.*;
import com.nondt.backend.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class AdminController {

    @Autowired
    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("/admin/{adminusername}/{adminpassword}")
    public Admin Admins(@PathVariable String adminusername, @PathVariable String adminpassword) {
        return adminRepository.findAll().stream()
                .filter(s -> s.getAdminpassword().equals(adminusername) && s.getAdminpassword().equals(adminpassword))
                .collect(Collectors.toList()).get(0);
    }
}