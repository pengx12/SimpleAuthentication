package com.example.util;

import java.util.Base64;

public class ToolUtil {

    public static String generateToken(String username) {
        String token=Base64.getEncoder().encodeToString((username).getBytes());
        return token;
    }

    public static String generateEncPassword(String password) {
        String token=Base64.getEncoder().encodeToString((password).getBytes());
        return token;
    }

    public static boolean checkExpiration(long expirytime,long lastAuthtime){

        if (lastAuthtime+expirytime>System.currentTimeMillis()){
            return true;
        }
        return false;

    }
    
}
