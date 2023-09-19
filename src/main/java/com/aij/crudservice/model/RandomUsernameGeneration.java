package com.aij.crudservice.model;
import java.util.UUID;
import java.util.Random;
public class RandomUsernameGeneration {

    public static String generateRandomUsername() {

        String[] username = {"John Smith", "Jane Doe", "Michael Johnson", "Emily Brown", "David Lee"};
        Random random = new Random();
        int randomIndex = random.nextInt(username.length);
        String randomName = username[randomIndex];
//        return UUID.randomUUID().toString();
        return (randomName);
    }
}
