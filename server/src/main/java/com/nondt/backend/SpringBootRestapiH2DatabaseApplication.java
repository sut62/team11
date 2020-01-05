package com.nondt.backend;
import com.nondt.backend.Entity.*;
import com.nondt.backend.Repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootRestapiH2DatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestapiH2DatabaseApplication.class, args);
    }

    @Bean
    ApplicationRunner init(BloodRepository bloodRepository , DepartmentRepository  departmentRepository
    , ProfileRepository profileRepository , GenderRepository genderRepository , MaritalstatusRepository maritalstatusRepository , RoomRepository roomrepository) {
        return args -> {


            Stream.of( "A","B","AB","O").forEach(bloods -> {
                Blood blood = new Blood();
                blood.setBlood(bloods);
                bloodRepository.save(blood);
            });


            Stream.of( "doctor","Ndoctor").forEach(departments -> {
                Department department = new Department();
                department.setDepartment(departments);
                departmentRepository.save(department);
            });

            Stream.of( "S","NS").forEach(maritalstatuss -> {
                Maritalstatus maritalstatus = new Maritalstatus();
                maritalstatus.setStatus(maritalstatuss);
                maritalstatusRepository.save(maritalstatus);
            });

            Stream.of( "M","FM").forEach(genders -> {
                Gender gender = new Gender();
                gender.setGender(genders);
                genderRepository.save(gender);
            });

            Stream.of( "ห้องผ่าตัด1","ห้องผ่าตัด2","ห้องผ่าตัด 3","ห้องตรวจ 1","ห้องตรวจ 2","ห้องตรวจภายใน","ห้องฉายรังสี",
            "ห้อง CT Scan1","ห้อง CT Scan 2","ห้อง X-ray","ห้องกายภาพ").forEach(rooms -> {
                Room room = new Room();
                room.setNameRoom(rooms);
                roomrepository.save(room);   
             });
        };
    }
}

