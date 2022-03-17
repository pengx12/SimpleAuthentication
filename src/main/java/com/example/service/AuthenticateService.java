package com.example.service;

public interface AuthenticateService {

    public String authenticate(String username, String password);

    public void invalidate(String token);
    
}
