package com.nondt.backend.Controller;

import com.nondt.backend.Entity.*;
import com.nondt.backend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private WorktimeRepository worktimeRepository;
    @Autowired
    private ProfileRepository profileRepository;

    public ScheduleController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping("/schedule")
    public Collection<Schedule> Schedules() {
        return scheduleRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/schedule/{profileSelect}/{departSelect}/{selectedDate}/{timeSelect}")
    public Schedule newschedule(Schedule newschedule,
            @PathVariable long profileSelect,
            @PathVariable long departSelect,
            @PathVariable String selectedDate,
            @PathVariable long timeSelect) {

        Profile profile = profileRepository.findById(profileSelect);
        Department department = departmentRepository.findById(departSelect);
        Worktime worktime = worktimeRepository.findById(timeSelect);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate scheduledate = LocalDate.parse(selectedDate, formatter);

        newschedule.setProfile_id(profile);
        newschedule.setDepartment_id(department);
        newschedule.setScheduledate(scheduledate);
        newschedule.setWorktime(worktime);

        return scheduleRepository.saveAndFlush(newschedule);

    }
}