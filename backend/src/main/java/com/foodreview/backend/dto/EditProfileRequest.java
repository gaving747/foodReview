package com.foodreview.backend.dto;

public class EditProfileRequest {
    private String bio;
    private String displayName;
    private Long userId;

    public EditProfileRequest() {}

    public EditProfileRequest(String bio, String displayName, Long userId){
        this.bio = bio;
        this.displayName = displayName;
        this.userId = userId;
    }


    public String getBio(){
        return bio;
    }
    public String getDisplayName(){
        return displayName;
    }
    public Long getUserId(){
        return userId;
    }

    public void setDisplayName(String displayName){
        this.displayName = displayName;
    }
    public void setBio(String bio){
        this.bio = bio;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }

}
