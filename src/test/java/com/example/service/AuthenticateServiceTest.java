package com.example.service;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.example.entity.TokenPool;
import com.example.entity.Users;
import com.example.serviceimpl.AuthenticateServiceImpl;


public class AuthenticateServiceTest {

    private static Users users=new Users();
    private static TokenPool tokenpool=new TokenPool();
    private static AuthenticateService authService=new AuthenticateServiceImpl(users, tokenpool);

    private static String username="admin";
    private static String password="123456";
    private static String token="";
    
    @BeforeClass
    public static void beforeAll() {
        users.addUser(password, username);

    }

    @Test
    public void testAuthenticate() {

        token=authService.authenticate(username, "wrongpassword");
        assertFalse(tokenpool.containsToken(token));
        token=authService.authenticate(username, password);
        assertTrue(tokenpool.containsToken(token));
    }

    @Test
    public void testInvalidate() {

        token=authService.authenticate(username, password);
        assertTrue(tokenpool.containsToken(token));
        authService.invalidate(token);
        assertFalse(tokenpool.containsToken(token));
    }
}
