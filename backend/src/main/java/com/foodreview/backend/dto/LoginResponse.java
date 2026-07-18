package com.foodreview.backend.dto;

public class LoginResponse {
    private boolean loginSuccessful;
    private String message;
    private Long id;

    public LoginResponse(){
    }

    public boolean getLoginSuccessful(){
        return loginSuccessful;
    }

    public String getMessage(){
        return message;
    }

    public Long getId(){
        return id;
    }

    public void setLoginSuccessful(boolean loginSuccessful){
        this.loginSuccessful = loginSuccessful;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setId(Long id){
        this.id = id;
    }
}
