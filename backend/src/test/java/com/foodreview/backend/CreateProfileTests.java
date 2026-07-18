package com.foodreview.backend;
import static org.junit.jupiter.api.Assertions.*;
import com.foodreview.backend.service.AuthService;
import com.foodreview.backend.dto.createProfileRequest;
import com.foodreview.backend.dto.createProfileResponse;
import org.junit.jupiter.api.Test;

public class CreateProfileTests {
    private AuthService authService;
    @Test
    public void checkIfCreationIsValid() {
        createProfileRequest request = new createProfileRequest();
        createProfileResponse response = authService.attemptCreateProfile(request);
        assertFalse(response.getCreationSuccessful());
    }
}
