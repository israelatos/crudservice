package com.aij.crudservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class CrudController {

    private Map<String, UserProfile> db = new HashMap<>(){{
        put("1", new UserProfile("1", "israelatos"));
    }};
//    private List<UserProfile> db = List.of();

    @GetMapping("/profile")
    public String getProfile() {
        String profile = RandomUsernameGeneration.generateRandomUsername();
        return "Hello, " + profile +"!";
    }

    @GetMapping("/user")
    public Collection<UserProfile> get() {
        return db.values();
    }

    @GetMapping("/user/{id}")
    public UserProfile get(@PathVariable String id) {
        UserProfile userProfile = db.get(id);
        if (userProfile == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return userProfile;
    }
}
