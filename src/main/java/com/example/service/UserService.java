package com.example.service;

import com.example.entity.TokenPool;

public interface UserService {
    
    
    public boolean addUser(String username, String password);

    public boolean deleteUser(String username, TokenPool tokenpool);



}
