package com.foodreview.backend.service;
import com.foodreview.backend.dto.LoginRequest;
import com.foodreview.backend.dto.LoginResponse;
import com.foodreview.backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodreview.backend.repository.AuthRepository;
import com.foodreview.backend.repository.ProfileRepository;
import com.foodreview.backend.dto.createProfileRequest;
import com.foodreview.backend.dto.createProfileResponse;
import com.foodreview.backend.model.ProfileModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    private AuthRepository authRepository;
    private ProfileRepository profileRepository;
    public AuthService(AuthRepository authRepository, ProfileRepository profileRepository){
        this.authRepository = authRepository;
        this.profileRepository = profileRepository;
    }

    public LoginResponse attemptLogin(LoginRequest request){
        String usernameOrEmail = request.getEmailOrUsername();
        String password = request.getPassword();
        String emailSpecific = usernameOrEmail.toLowerCase();
        LoginResponse loginResponse = new LoginResponse();

        UserModel info = authRepository.findByEmail(emailSpecific);
        if(info == null){
            info = authRepository.findByUsername(usernameOrEmail);
        }

        if(info == null){
            loginResponse.setLoginSuccessful(false);
            loginResponse.setId(null);
            loginResponse.setMessage("Email or username is not recognized.");
            return loginResponse;
        }

        if(info != null) {
            boolean matches = passwordEncoder.matches(password, info.getPassword());
            if (matches) {
                loginResponse.setLoginSuccessful(true);
                loginResponse.setId(info.getId());
                loginResponse.setMessage("Login successful.");
            }
            else{
                loginResponse.setLoginSuccessful(false);
                loginResponse.setId(null);
                loginResponse.setMessage("Passwords don't match.");
            }
            return loginResponse;
        }
        loginResponse.setLoginSuccessful(false);
        loginResponse.setId(null);
        loginResponse.setMessage("Error has occurred.");
        return loginResponse;
    }

    public createProfileResponse attemptCreateProfile(createProfileRequest request){
        String email = request.getEmail();
        String username = request.getUsername();
        String password = request.getPassword();
        String displayName = request.getDisplayName();

        email = email.toLowerCase();
        String hashedPassword = passwordEncoder.encode(password);
        //username = username.toLowerCase();
        //logic to actually check the email, username, and password before sent to database will go here
        createProfileResponse response = new createProfileResponse();
        boolean emailExists = authRepository.existsByEmail(email);
        boolean usernameExists = authRepository.existsByUsername(username);

        if(emailExists){
            response.setId(null);
            response.setMessage("This email already has an account.");
            response.setCreationSuccessful(false);
            return response;
        }
        if(usernameExists){
            response.setId(null);
            response.setMessage("This username has already been taken.");
            response.setCreationSuccessful(false);
            return response;
        }
        if(displayName.isEmpty()){
            response.setId(null);
            response.setMessage("Invalid display name.");
            response.setCreationSuccessful(false);
            return response;
        }



        UserModel info = new UserModel();
        info.setEmail(email);
        info.setUsername(username);
        info.setPassword(hashedPassword);
        UserModel returnedInfo = authRepository.save(info);

        ProfileModel profileInfo = new ProfileModel();
        //super important line, links user id to profile id
        profileInfo.setUserId(info.getId());
        profileInfo.setDisplayName(displayName);
        ProfileModel returnedProfileInfo = profileRepository.save(profileInfo);

        if(returnedInfo != null && returnedProfileInfo != null) {
            response.setId(returnedInfo.getId());
            response.setMessage("Your account has been successfully created.");
            response.setCreationSuccessful(true);
            return response;
        }

        response.setId(null);
        response.setMessage("An error has occured");
        response.setCreationSuccessful(false);
        return response;
    }
}
