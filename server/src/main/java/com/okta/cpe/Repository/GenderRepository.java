package com.okta.cpe.Repository;

import com.okta.cpe.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RepositoryRestResource

public
interface GenderRepository extends JpaRepository<Gender, Long> {
    Gender findById(long gender_id);

}