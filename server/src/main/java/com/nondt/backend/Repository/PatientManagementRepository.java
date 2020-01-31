package com.nondt.backend.Repository;

import java.util.Optional;

import com.nondt.backend.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PatientManagementRepository extends JpaRepository<PatientManagement, Long> {
    PatientManagement findById(long patient_id);

}