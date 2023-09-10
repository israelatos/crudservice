package com.aij.crudservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CrudController {

    private List<UserProfile> db = List.of(new UserProfile("1", "israelatos"));

    @GetMapping("/profile")
    public String getProfile() {
        String profile = RandomUsernameGeneration.generateRandomUsername();
        return "Hello, " + profile +"!";
    }

    @GetMapping("/user")
    public List<UserProfile> get() {
        return db;
    }
}
