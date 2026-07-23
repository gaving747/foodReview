package com.foodreview.backend.dto;

public class AskForPasswordRequest {
    private Long userId;
    private String password;

    public AskForPasswordRequest(Long userId, String password){
        this.userId = userId;
        this.password = password;
    }


    public Long getUserId(){
        return userId;
    }

    public String getPassword(){
        return password;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
