package com.okta.cpe.Repository;

import com.okta.cpe.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RepositoryRestResource

public
interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findById(long profile_id);

}