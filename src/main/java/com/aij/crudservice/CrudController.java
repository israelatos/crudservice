package com.aij.crudservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CrudController {

    @GetMapping("/profile")
    public String getProfile() {
        String profile = RandomUsernameGeneration.generateRandomUsername();
        return "Hello: " + profile;
    }
}
