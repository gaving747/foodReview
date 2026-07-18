package com.foodreview.backend.model;
import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class ProfileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "bio")
    private String bio;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    public ProfileModel(){}

    public Long getId(){
        return id;
    }
    public Long getUserId(){
        return userId;
    }
    public String getDisplayName(){
        return displayName;
    }
    public String getBio(){
        return bio;
    }
    public String getProfilePictureURL(){
        return profilePictureUrl;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }
    public void setDisplayName(String displayName){
        this.displayName = displayName;
    }
    public void setBio(String bio){
        this.bio = bio;
    }
    public void setProfilePictureURL(String profilePictureUrl){
        this.profilePictureUrl = profilePictureUrl;
    }



}
