package com.nondt.backend.Controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


import com.nondt.backend.Entity.*;
import com.nondt.backend.Repository.*;


import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class RecipeController {

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Autowired
    private final RecipeRepository recipeRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private TypemedicineRepository typemedicineRepository;
    @Autowired
    private TypepackingRepository typepackingRepository;
    @Autowired
    private PatientManagementRepository patientManagementRepository;
    




    @PostMapping("/recipe/{nummed}/{medicineSelect}/{typeSelect}/{amount}/{selectDate}/{profileSelect}/{patSelect}/{typepackingSelect}")
    public void newRecipe(
                        @PathVariable long nummed,
                        @PathVariable long medicineSelect,
                        @PathVariable long typeSelect,
                        @PathVariable long amount,
                        @PathVariable String selectDate,
                        @PathVariable long profileSelect,
                        @PathVariable long patSelect,
                        @PathVariable long typepackingSelect) 
                  {
                    Recipe recipe = new Recipe();
                    Medicine medicine = medicineRepository.findById(medicineSelect);
                    Typemedicine typemedicine = typemedicineRepository.findById(typeSelect);
                    Profile profile = profileRepository.findById(profileSelect);
                    PatientManagement patientManagement = patientManagementRepository.findById(patSelect);
                    Typepacking typepacking = typepackingRepository.findById(typepackingSelect);
                    recipe.setNumber(nummed);
                    recipe.setAmount(amount);
                    String[] b = selectDate.split(" ");
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
            recipe.setDate(localDate);
            recipe.setMedicine(medicine);
            recipe.setPatientManagement(patientManagement);
            recipe.setProfile(profile);
            recipe.setTypemedicine(typemedicine);
            recipe.setTypepacking(typepacking);
            recipeRepository.save(recipe);
    }
    

}