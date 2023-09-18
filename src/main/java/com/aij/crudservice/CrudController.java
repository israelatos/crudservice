package com.aij.crudservice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class CrudController {

    private final Map<String, UserProfile> db = new HashMap<>();
    private int idCounter = 1; // Initialize the counter to 1
    private final List<String> randomNames = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank");

    @PostMapping("/user")
    public UserProfile createUser(@RequestBody UserProfile userProfile) {
        String randomId = Integer.toString(idCounter++);
//        String randomName = getRandomName();

        userProfile.setId(randomId);
//        userProfile.setName(randomName);

        db.put(userProfile.getId(), userProfile);

        return userProfile;
    }

    // Define getRandomName() method within the CrudController class
    private String getRandomName() {
        Random random = new Random();
        int randomIndex = random.nextInt(randomNames.size());
        return randomNames.get(randomIndex);
    }

    @GetMapping("/profile")
    public String getProfile() {
        String profile = RandomUsernameGeneration.generateRandomUsername();
        return "Hello, " + profile + "!";
    }

    @GetMapping("/user")
    public Collection<UserProfile> getAllUsers() {
        return db.values();
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserById(@PathVariable String id) {
        UserProfile userProfile = db.get(id);
        if (userProfile == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return userProfile;
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable String id) {
        UserProfile userProfile = db.remove(id);
        if (userProfile == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
