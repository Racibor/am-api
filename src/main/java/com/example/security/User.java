package com.example.security;

public class User {
    public String login;
    public String pass;
    public boolean registered;

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
        this.registered = false;
    }

    public User(String login, String pass, boolean registered) {
        this.login = login;
        this.pass = pass;
        this.registered = registered;
    }
}
