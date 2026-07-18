package com.foodreview.backend.controller;
import com.foodreview.backend.dto.EditProfileRequest;
import com.foodreview.backend.dto.EditProfileResponse;
import org.springframework.web.bind.annotation.*;
import com.foodreview.backend.service.ProfileService;
import com.foodreview.backend.dto.generalInfoResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/profile")
public class ProfileController {
    private ProfileService profileService;

    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    @PatchMapping("/updateProfile")
    public EditProfileResponse editProfileResponse(@RequestBody EditProfileRequest editProfileRequest){
        return profileService.editProfile(editProfileRequest);
    }

    @GetMapping("/retrieveInfo")
    public generalInfoResponse getGeneralInfo(@RequestParam Long userId){
        return profileService.getGeneralInformation(userId);
    }


}
