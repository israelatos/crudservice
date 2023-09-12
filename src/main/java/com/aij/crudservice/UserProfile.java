package com.aij.crudservice;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
public class UserProfile {

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

    // Getter and setter methods for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
