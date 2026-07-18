package com.foodreview.backend;
import com.foodreview.backend.service.AuthService;
import org.junit.jupiter.api.Test;
import com.foodreview.backend.dto.LoginRequest;
import com.foodreview.backend.dto.LoginResponse;
import static org.junit.jupiter.api.Assertions.*;


public class LoginTests {
    //test if a user using a known account and right password can get approved
    private AuthService authService;
    @Test
    void knownUserLogin(){
        //add attributes!
        LoginRequest testLogin = new LoginRequest();
        LoginResponse response = authService.attemptLogin(testLogin);
        assertTrue(response.getLoginSuccessful());
    }

    //test if it correctly does not allow an unknown account
    @Test
    void unknownUserLogin(){
        //add attributes!
        LoginRequest testLogin = new LoginRequest();
        LoginResponse response = authService.attemptLogin(testLogin);
        assertFalse(response.getLoginSuccessful());
    }

    @Test
    void passwordNotMatching(){
        //add attributes!
        LoginRequest testLogin = new LoginRequest();
        LoginResponse response = authService.attemptLogin(testLogin);
        assertEquals("Passwords don't match.", response.getMessage());
    }

}
