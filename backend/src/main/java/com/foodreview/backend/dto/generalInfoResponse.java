package com.foodreview.backend.dto;

public class generalInfoResponse {
    private String email;
    private String username;
    private String displayName;
    private String bio;

    public String getBio(){
        return bio;
    }
    public String getDisplayName(){
        return displayName;
    }
    public String getEmail(){
        return email;
    }
    public String getUsername(){
        return username;
    }

    public void setDisplayName(String displayName){
        this.displayName = displayName;
    }
    public void setBio(String bio){
        this.bio = bio;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
