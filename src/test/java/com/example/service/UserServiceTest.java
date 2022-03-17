package com.example.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.entity.TokenPool;
import com.example.entity.Users;
import com.example.serviceimpl.UserServiceImpl;

import org.junit.Test;

public class UserServiceTest {
    
    private static Users users=new Users();
    private static UserService userService=new UserServiceImpl(users);
    private static TokenPool tokenpool=new TokenPool();
    String username="admin";
    String password="123456";
    
    @Test
    public void testAddUser() {
        assertTrue(userService.addUser(username, password)); // if not exists, add
        assertTrue(users.containsUser(username)); //if exists, return false
    }

    @Test
    public void testDeleteUser() {
        userService.addUser(username, password); 
        assertTrue(userService.deleteUser(username, tokenpool)); // delete user
        assertFalse(users.containsUser(username)); //deleted successful
        assertFalse(userService.deleteUser(username, tokenpool)); //if not exists, return false
    }
}
