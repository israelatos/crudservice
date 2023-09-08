package com.aij.crudservice;
import java.util.UUID;
public class RandomUsernameGeneration {

    public static String generateRandomUsername() {
        return UUID.randomUUID().toString();
    }
}
