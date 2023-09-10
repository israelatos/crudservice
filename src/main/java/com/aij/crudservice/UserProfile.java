package com.aij.crudservice;

import lombok.Data;

@Data
public class UserProfile {
    public UserProfile() {
        this.id = id;
        this.userName = userName;
    }

    private String id;
    private String userName;
//    other information

    public UserProfile(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }
}
