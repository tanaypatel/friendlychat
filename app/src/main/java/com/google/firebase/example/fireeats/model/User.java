package com.google.firebase.example.fireeats.model;

/**
 * Created by tp0986611 on 12/6/2017.
 */

public class User {
    private String uid;
    private String userEmail;
    private String photoURL;
    private String displayName;
    private String schoolName;
    private String userType;

    public User(String uid, String userEmail, String photoURL, String displayName, String schoolName, String userType){
        this.uid = uid;
        this.userEmail = userEmail;
        this.photoURL = photoURL;
        this.displayName = displayName;
        this.schoolName = schoolName;
        this.userType = userType;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
