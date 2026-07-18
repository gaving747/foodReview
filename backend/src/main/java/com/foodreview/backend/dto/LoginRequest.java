package com.foodreview.backend.dto;

public class LoginRequest {
    private String emailOrUsername;
    private String password;

    public LoginRequest(){
    }

    public LoginRequest(String emailOrUsername, String password){
        this.emailOrUsername = emailOrUsername;
        this.password = password;
    }


    public String getEmailOrUsername(){
        return emailOrUsername;
    }

    public String getPassword(){
        return password;
    }

    public void setEmailOrUsername(String emailOrUsername){
        this.emailOrUsername = emailOrUsername;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
