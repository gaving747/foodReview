package com.foodreview.backend.dto;

public class generalInfoRequest {
    private Long userId;

    public generalInfoRequest(){}

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId(){
        return userId;
    }
}
