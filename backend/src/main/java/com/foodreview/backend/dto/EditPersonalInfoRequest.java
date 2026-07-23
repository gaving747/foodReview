package com.foodreview.backend.dto;

public class EditPersonalInfoRequest {
    private Long userId;
    private String email;
    private String username;

    public EditPersonalInfoRequest(){}

    public EditPersonalInfoRequest(Long userId, String email, String username){
        this.userId = userId;
        this.email = email;
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }
    public String getEmail(){
        return email;
    }
    public String getUsername(){
        return username;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setUsername(String username){
        this.username = username;
    }



}
