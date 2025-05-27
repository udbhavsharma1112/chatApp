package com.chat.auth;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "Email")
public class User {
    private String userName;
    private String Email;
    private boolean verified = false;

    public User(String userName, String Email) {
        this.userName = userName;
        this.Email = Email;
        this.verified = true;
    }

    public User() {}

    public String getUserName() {
        return this.userName;
    }

    public String getEmail() {
        return this.Email;
    }

    public boolean isVerified () {
        return this.verified;
    }

}   
