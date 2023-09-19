package com.aij.crudservice.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;

@Data
public class UserProfile {

    // Getter and setter methods for id
    @Getter
    private String id;
    @NotEmpty
    private String userName;
    // Other information fields if needed

}
