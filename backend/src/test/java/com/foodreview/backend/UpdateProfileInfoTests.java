package com.foodreview.backend;
import static org.junit.jupiter.api.Assertions.*;
import com.foodreview.backend.service.ProfileService;
import com.foodreview.backend.dto.EditProfileRequest;
import com.foodreview.backend.dto.EditProfileResponse;



import org.junit.jupiter.api.Test;

public class UpdateProfileInfoTests {
    private ProfileService profileService;

    @Test
    public void updateProfile(){
        EditProfileRequest request = new EditProfileRequest("test done", "test done", 1L);
        EditProfileResponse myResponse = profileService.editProfile(request);
        assertTrue(myResponse.getCreationSuccessful());
    }

    @Test
    public void updateProfileFalse(){
        EditProfileRequest request = new EditProfileRequest("test done", "test done", -1L);
        EditProfileResponse myResponse = profileService.editProfile(request);
        assertFalse(myResponse.getCreationSuccessful());
    }
}
