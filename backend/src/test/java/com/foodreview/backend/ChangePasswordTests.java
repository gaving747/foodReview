package com.foodreview.backend;

import com.foodreview.backend.dto.AskForPasswordRequest;
import com.foodreview.backend.service.PersonalCustomizationService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangePasswordTests {
    private PersonalCustomizationService service;

    @Test
    public void tryRegularPassword(){
        AskForPasswordRequest request = new AskForPasswordRequest(24L, "test5Password");
        assertTrue(service.changePassword(request));
    }

    @Test
    public void tryEmptyPassword(){
        AskForPasswordRequest request = new AskForPasswordRequest(24L, "");
        assertFalse(service.changePassword(request));
    }
}
