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
public class ScheduleController {

    @Autowired
    private final ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping("/schedule")
    public Collection<Schedule> Schedules() {
        return scheduleRepository.findAll().stream().collect(Collectors.toList());
    }

}