package com.aij.crudservice;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.Getter;

@Data
public class UserProfile {

    // Getter and setter methods for id
    @Getter
    private String id;
    private String userName;
    // Other information fields if needed

    public UserProfile() {
        // Default constructor is necessary for deserialization
    }

    public UserProfile(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String randomName) {
    }
}
