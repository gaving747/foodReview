package com.foodreview.backend.service;
import com.foodreview.backend.dto.EditProfileResponse;
import com.foodreview.backend.dto.EditProfileRequest;
import com.foodreview.backend.dto.generalInfoResponse;
import com.foodreview.backend.repository.AuthRepository;
import com.foodreview.backend.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.foodreview.backend.dto.generalInfoProfileResponse;
import com.foodreview.backend.dto.generalInfoUsersResponse;

@Service
@Transactional
public class ProfileService {

    private AuthRepository authRepository;
    private ProfileRepository profileRepository;

    public ProfileService(AuthRepository authRepository, ProfileRepository profileRepository){
        this.authRepository = authRepository;
        this.profileRepository = profileRepository;
    }

    public EditProfileResponse editProfile(EditProfileRequest profileRequest){
        String bio = profileRequest.getBio();
        String displayName = profileRequest.getDisplayName();
        Long userId = profileRequest.getUserId();
        EditProfileResponse response = new EditProfileResponse();

        if(displayName.isEmpty()){
            response.setId(null);
            response.setMessage("Display name left blank");
            response.setCreationSuccessful(false);
            return response;
        }

        if(userId == null) {
            response.setId(null);
            response.setMessage("Error with retrieving user ID");
            response.setCreationSuccessful(false);
            return response;
        }

        int rowsUpdated = profileRepository.updateProfileInfo(
                bio,
                displayName,
                userId
        );

        if(rowsUpdated > 0){
            response.setId(userId);
            response.setMessage("Information changed successfully.");
            response.setCreationSuccessful(true);
            return response;
        }

        response.setId(null);
        response.setMessage("An error has occurred");
        response.setCreationSuccessful(false);
        return response;

    }

    public generalInfoResponse getGeneralInformation(Long userID){
        generalInfoResponse myResponse = new generalInfoResponse();

        generalInfoProfileResponse myProfileResponse = profileRepository.getProfileInfoFromDatabase(userID);
        generalInfoUsersResponse myUsersResponse = authRepository.getUserInfoFromDatabase(userID);


        if(myUsersResponse == null ){
            myResponse.setEmail("user not found");
            myResponse.setBio("user not found");
            myResponse.setUsername("user not found");
            myResponse.setDisplayName("user not found");
        }

        else {
            myResponse.setDisplayName(myProfileResponse.getDisplayName());
            myResponse.setBio(myProfileResponse.getBio());
            myResponse.setEmail(myUsersResponse.getEmail());
            myResponse.setUsername(myUsersResponse.getUsername());
        }

        return myResponse;
    }
}
