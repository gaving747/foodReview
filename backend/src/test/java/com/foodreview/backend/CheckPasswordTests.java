package com.foodreview.backend;

import com.foodreview.backend.dto.AskForPasswordRequest;
import com.foodreview.backend.service.PersonalCustomizationService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CheckPasswordTests {
    private PersonalCustomizationService service;

    @Test
    public void checkIfTrueWorks(){
        AskForPasswordRequest request = new AskForPasswordRequest(24L, "test5Password");
        assertTrue(service.checkPassword(request));
    }

    @Test
    public void checkIfFalseWorks(){
        AskForPasswordRequest request = new AskForPasswordRequest(24L, "randomCrap");
        assertFalse(service.checkPassword(request));
    }


}
