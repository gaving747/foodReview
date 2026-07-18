package com.foodreview.backend.dto;

public class createProfileRequest {
    private String email;
    private String username;
    private String password;
    private String displayName;

    public createProfileRequest(){}

    public createProfileRequest(String email, String username, String password, String displayName){
        this.email = email;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
    }

    public String getEmail(){
        return email;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public String getDisplayName(){
        return displayName;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public void setDisplayName (String displayName){
        this.displayName = displayName;
    }


}
