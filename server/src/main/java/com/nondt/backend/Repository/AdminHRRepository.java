package com.cpe.backend.repository.employee;

import com.cpe.backend.entity.employee_entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AdminHRRepository extends JpaRepository<AdminHR, Long> {
   
}
