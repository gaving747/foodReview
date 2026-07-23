package com.foodreview.backend;
import com.foodreview.backend.dto.EditPersonalInfoRequest;
import com.foodreview.backend.service.PersonalCustomizationService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EditPersonalInformationTests {
    private PersonalCustomizationService service;

    @Test
    public void testForRepeatedEmail(){
        EditPersonalInfoRequest request = new EditPersonalInfoRequest(24L, "testEmail5change@gmail.com", "completelyRandomUsername");
        assertFalse(service.editPersonalInfo(request).getSwitchSuccessful());
    }

    @Test
    public void testForRepeatedUsername(){
        EditPersonalInfoRequest request = new EditPersonalInfoRequest(24L, "completelyRandomEmail@gmail.com", "test5change");
        assertFalse(service.editPersonalInfo(request).getSwitchSuccessful());
    }

}
