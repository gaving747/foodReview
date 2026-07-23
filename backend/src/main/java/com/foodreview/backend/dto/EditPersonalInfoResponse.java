package com.foodreview.backend.dto;

public class EditPersonalInfoResponse {
    private boolean switchSuccessful;
    private String message;
    private Long id;

    public EditPersonalInfoResponse(){
    }

    public boolean getSwitchSuccessful(){
        return switchSuccessful;
    }

    public String getMessage(){
        return message;
    }

    public Long getId(){
        return id;
    }

    public void setSwitchSuccessful(boolean switchSuccessful){
        this.switchSuccessful = switchSuccessful;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setId(Long id){
        this.id = id;
    }
}
