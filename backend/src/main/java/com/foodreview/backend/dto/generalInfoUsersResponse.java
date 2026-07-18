package com.foodreview.backend.dto;

public class generalInfoUsersResponse {
    private String email;
    private String username;

    public generalInfoUsersResponse(){};

    public generalInfoUsersResponse(String email, String username){
        this.email = email;
        this.username = username;
    }

    public String  getEmail(){
        return email;
    }
    public String getUsername(){
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
