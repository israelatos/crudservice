package com.aij.crudservice;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
//
//    public void setId(String string) {
//    }
//
//    public String getId() {
//        return JsonTypeInfo.Id;
//    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
