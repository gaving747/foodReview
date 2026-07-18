package com.foodreview.backend;
import com.foodreview.backend.dto.generalInfoResponse;
import com.foodreview.backend.service.ProfileService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RetrieveInfoTests {
    private ProfileService profileService;

    @Test
    public void checkRetrieveInfo() {
        generalInfoResponse response = profileService.getGeneralInformation(1L);
        assertNotEquals("user not found", response.getEmail());
    }

    @Test
    public void notRecognizedID() {
        generalInfoResponse response = profileService.getGeneralInformation(-1L);
        assertEquals("user not found", response.getEmail());
    }
}
