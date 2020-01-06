package com.nondt.backend.Controller;

import com.nondt.backend.Entity.*;
import com.nondt.backend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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
    public void newRecipe(
        
                        
                        @PathVariable long profileSelect,
                        @PathVariable long departSelect,
                        @PathVariable String selectedDate,
                        @PathVariable long timeSelect
                        ) 
                  {
                    
                    Profile profile = profileRepository.findById(profileSelect);
                    
                    Department department = departmentRepository.findById(departSelect);
                    Worktime worktime = worktimeRepository.findById(timeSelect);
                    Schedule schedule = new Schedule();
                    schedule.setDepartment_id(department);
                    schedule.setWorktime(worktime);
                    schedule.setProfile_id(profile);
                    
                    String[] b = selectedDate.split(" ");
            int year = Integer.valueOf(b[3]);

            int day = Integer.valueOf(b[2]);
            int month = 1 ;

            if(b[1].equalsIgnoreCase("Jan")){ month = 1;}else if(b[1].equalsIgnoreCase("Feb")){ month = 2;}
            else if(b[1].equalsIgnoreCase("Mar")){ month = 3;}else if(b[1].equalsIgnoreCase("Mar")){ month = 4;}
            else if(b[1].equalsIgnoreCase("May")){ month = 5;}else if(b[1].equalsIgnoreCase("Jun")){ month = 6;}
            else if(b[1].equalsIgnoreCase("Jul")){ month = 7;}else if(b[1].equalsIgnoreCase("Aug")){ month = 8;}
            else if(b[1].equalsIgnoreCase("Sep")){ month = 9;}else if(b[1].equalsIgnoreCase("Oct")){ month = 10;}
            else if(b[1].equalsIgnoreCase("Nov")){ month = 11;}else if(b[1].equalsIgnoreCase("Dec")){ month = 12;}


            LocalDate localDate = LocalDate.of(year,month,day);
            schedule.setScheduledate(localDate);
            scheduleRepository.save(schedule);
    }
}