package com.aij.crudservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/")
public class CrudController {

    private Map<String, UserProfile> db = new HashMap<>(){{
        put("1", new UserProfile("1", "israelatos"));
    }};
    private final List<String> randomNames = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank");

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

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable String id) {
        UserProfile userProfile = db.remove(id);
        if (userProfile == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

//    @PostMapping("/user")
//    public UserProfile create(UserProfile userProfile) {
//        userProfile.setId(UUID.randomUUID().toString());
//        db.put(userProfile.getId(), userProfile);
//        return userProfile;
//    }


    @PostMapping("/user")
    public UserProfile create() {
        String randomId = UUID.randomUUID().toString();
        String randomName = getRandomName();

        UserProfile userProfile = new UserProfile(randomId, randomName);
        db.put(userProfile.getId(), userProfile);

        return userProfile;
    }

    private String getRandomName() {
        Random random = new Random();
        int randomIndex = random.nextInt(randomNames.size());
        return randomNames.get(randomIndex);
    }
}
