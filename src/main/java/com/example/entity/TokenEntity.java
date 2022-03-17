package com.example.entity;

public class TokenEntity {
    
    private String token;

    public TokenEntity(String token, long lastAuthTime, User user) {
        this.token = token;
        this.lastAuthTime = lastAuthTime;
        this.user = user;
    }

    private long lastAuthTime;

    private User user;


    public long getLastAuthTime() {
        return lastAuthTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLastAuthTime(long lastAuthTime) {
        this.lastAuthTime = lastAuthTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
