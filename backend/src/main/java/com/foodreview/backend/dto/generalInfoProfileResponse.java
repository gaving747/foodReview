package com.foodreview.backend.dto;

public class generalInfoProfileResponse {
    private String displayName;
    private String bio;

    public generalInfoProfileResponse(){};

    public generalInfoProfileResponse(String displayName, String bio) {
        this.displayName = displayName;
        this.bio = bio;
    }

    public String getBio(){
        return bio;
    }
    public String getDisplayName(){
        return displayName;
    }

    public void setDisplayName(String displayName){
        this.displayName = displayName;
    }
    public void setBio(String bio){
        this.bio = bio;
    }
}
