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
    ApplicationRunner init(BloodRepository bloodRepository , DepartmentRepository  departmentRepository, AppointmenttimeRepository appointmenttimeRepository
    , ProfileRepository profileRepository , GenderRepository genderRepository , MaritalstatusRepository maritalstatusRepository 
    , MedicineRepository MedicineRepository , TypemedicineRepository typemedicineRepository,WorktimeRepository worktimeRepository) {
        return args -> {


            Stream.of( "A","B","AB","O").forEach(bloods -> {
                Blood blood = new Blood();
                blood.setBlood(bloods);
                bloodRepository.save(blood);
            });


            Stream.of( "แผนกฉุกเฉินและอุบัติเหตุ","แผนกรังสีกรรม","แผนกห้องปฏิบัติการทางการแพทย์","แผนกศัลยกรรม","แผนกวิสัญญี","แผนกกุมารเวชกรรม","แผนกอายุรกรรม").forEach(departments -> {
                Department department = new Department();
                department.setDepartment(departments);
                departmentRepository.save(department);
            });

            Stream.of( "โสด","สมรส", "หย่าร้าง").forEach(maritalstatuss -> {
                Maritalstatus maritalstatus = new Maritalstatus();
                maritalstatus.setStatus(maritalstatuss);
                maritalstatusRepository.save(maritalstatus);
            });

            Stream.of( "หญิง","ชาย").forEach(genders -> {
                Gender gender = new Gender();
                gender.setGender(genders);
                genderRepository.save(gender);
            });

            Stream.of( "10:00-12:00 น.","13:00-15:00 น.","18:00-20:00 น.").forEach(timeap -> {
                Appointmenttime appointmenttime = new Appointmenttime();
                appointmenttime.setTimeap(timeap);
                appointmenttimeRepository.save(appointmenttime);
            });

            Stream.of( "ยาพารา","ยาแก้ปวด","ยาแก้ไข้").forEach(timeap -> {
                Medicine medicine = new Medicine();
                medicine.setMedicine_name(timeap);
                MedicineRepository.save(medicine);
            });

            Stream.of( "เม็ด","แคปซูล","น้ำ","ผง" ).forEach(timeap -> {
                Typemedicine typemedicine = new Typemedicine();
                typemedicine.setTypemedicine_name(timeap);
                typemedicineRepository.save(typemedicine);
            });

            Stream.of( "เช้า","บ่าย","ดึก" ).forEach(worktime1 -> {
                Worktime worktime = new Worktime();
                worktime.setWork(worktime1);
                worktimeRepository.save(worktime);
            });

            Department department = departmentRepository.findById(1);
            Gender gender = genderRepository.findById(1);
            Blood blood = bloodRepository.findById(1);
            Maritalstatus maritalstatus = maritalstatusRepository.findById(1);
            Profile profile = new Profile();
            profile.setName("Suwanun Pe");
            profile.setPhone("0900000000");
            profile.setAge(40);
            profile.setAddress("Suranaree");
            profile.setBlood(blood);
            profile.setGender(gender);
            profile.setDepartment(department);
            profile.setMaritalstatus(maritalstatus);
            profileRepository.save(profile);


        };
    }
}

