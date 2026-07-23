package com.foodreview.backend.controller;

import com.foodreview.backend.dto.*;
import com.foodreview.backend.service.PersonalCustomizationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/personalInfo")
public class PersonalInfoController {

    private PersonalCustomizationService personalCustomizationService;

    public PersonalInfoController(PersonalCustomizationService personalCustomizationService){
        this.personalCustomizationService = personalCustomizationService;
    }

    @PostMapping("/checkPassword")
    public boolean askForPassword(@RequestBody AskForPasswordRequest request){
        return personalCustomizationService.checkPassword(request);
    }

    @PatchMapping("/updatePersonalInfo")
    public EditPersonalInfoResponse editProfileInformation(@RequestBody EditPersonalInfoRequest editPersonalInfoRequest){
        return personalCustomizationService.editPersonalInfo(editPersonalInfoRequest);
    }

    @PatchMapping("/changePassword")
    public boolean changeMyPassword(@RequestBody AskForPasswordRequest request){
        return personalCustomizationService.changePassword(request);
    }

}
