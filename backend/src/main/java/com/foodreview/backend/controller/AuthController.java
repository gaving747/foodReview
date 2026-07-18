package com.foodreview.backend.controller;
import org.springframework.web.bind.annotation.*;
import com.foodreview.backend.dto.LoginRequest;
import com.foodreview.backend.dto.LoginResponse;
import com.foodreview.backend.dto.createProfileRequest;
import com.foodreview.backend.dto.createProfileResponse;
import com.foodreview.backend.service.AuthService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/checkLoginInfo")
    public LoginResponse attemptToLogUserIn(@RequestBody LoginRequest request){
        return authService.attemptLogin(request);
    }

    @PostMapping("/createNewProfile")
    public createProfileResponse attemptToCreateProfile(@RequestBody createProfileRequest request){
        return authService.attemptCreateProfile(request);
    }


}
