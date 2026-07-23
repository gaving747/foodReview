package com.foodreview.backend.service;

import com.foodreview.backend.dto.EditPersonalInfoRequest;
import com.foodreview.backend.dto.EditPersonalInfoResponse;
import com.foodreview.backend.model.UserModel;
import com.foodreview.backend.repository.AuthRepository;
import com.foodreview.backend.dto.AskForPasswordRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonalCustomizationService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    private AuthRepository authRepository;
    public PersonalCustomizationService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public boolean checkPassword(AskForPasswordRequest request){
        Long userId = request.getUserId();
        String password = request.getPassword();

        UserModel user = authRepository.findUserById(userId);

        if (user == null) {
            return false;
        }

        return passwordEncoder.matches(password, user.getPassword());
    }

    @Transactional
    public EditPersonalInfoResponse editPersonalInfo(EditPersonalInfoRequest request){
        String email = request.getEmail();
        email = email.toLowerCase();
        String username = request.getUsername();
        Long userId = request.getUserId();

        EditPersonalInfoResponse response = new EditPersonalInfoResponse();

        boolean emailSame = authRepository.existsByIdAndEmail(userId, email);
        boolean usernameSame = authRepository.existsByIdAndUsername(userId, username);
        boolean emailExists;
        boolean usernameExists;

        if(emailSame){
            emailExists = false;
        }
        else{
            emailExists = authRepository.existsByEmail(email);
        }

        if(usernameSame) {
            usernameExists = false;
        }
        else{
            usernameExists = authRepository.existsByUsername(username);
        }


        if(emailExists){
            response.setMessage("This email already has an account.");
            response.setSwitchSuccessful(false);
            return response;
        }
        if(usernameExists){
            response.setMessage("This username has already been taken.");
            response.setSwitchSuccessful(false);
            return response;
        }

        int rowsUpdated = authRepository.updateUserInfo(
                email,
                username,
                userId
        );

        if(rowsUpdated > 0){
            response.setMessage("Information changed successfully.");
            response.setSwitchSuccessful(true);
            return response;
        }

        response.setMessage("An error has occurred");
        response.setSwitchSuccessful(false);
        return response;
    }
    @Transactional
    public boolean changePassword(AskForPasswordRequest request){
        Long userId = request.getUserId();
        String password = request.getPassword();
        String hashedPassword = passwordEncoder.encode(password);

        if(password.isEmpty()){
            return false;
        }

        int rowsUpdated = authRepository.updatePassword(hashedPassword, userId);

        return rowsUpdated > 0;
    }
}
