package com.example.security;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    Map<String, User> users;

    public UserRepository() {
        this.users = new HashMap<>();
        users.put("przemo", new User("przemo", "pass", true));
        users.put("ala", new User("ala", "pass", true));
    }

    public User getUser(String key) {
        return users.get(key);
    }
}
