package com.foodreview.backend.dto;

public class EditProfileResponse {
    private boolean creationSuccessful;
    private String message;
    private Long id;

    public EditProfileResponse(){
    }

    public boolean getCreationSuccessful(){
        return creationSuccessful;
    }

    public String getMessage(){
        return message;
    }

    public Long getId(){
        return id;
    }

    public void setCreationSuccessful(boolean creationSuccessful){
        this.creationSuccessful = creationSuccessful;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setId(Long id){
        this.id = id;
    }
}
