package com.example.serviceimpl;

import com.example.entity.TokenPool;
import com.example.entity.User;
import com.example.entity.Users;
import com.example.service.AuthenticateService;
import com.example.util.DefinedConstant;
import com.example.util.ToolUtil;

public class AuthenticateServiceImpl implements AuthenticateService{

    private Users users;

    private TokenPool tokenpool;

    public AuthenticateServiceImpl(Users users,TokenPool tokenpool){
        this.users=users;
        this.tokenpool=tokenpool;
    }

    public String authenticate(String username, String password){
        User user=users.getUserbyName(username);
        // String a=ToolUtil.generateEncPassword(password);
        if (user.getPassword().equals(ToolUtil.generateEncPassword(password)))
        {
            String token=ToolUtil.generateToken(username);
            long currentTime=System.currentTimeMillis();
            this.tokenpool.addToken(token, currentTime, user);
            return token;
        }
        else{
            return DefinedConstant.Error_Message;
        }
    }

    public void invalidate(String token){
        this.tokenpool.removeToken(token);
    }

}
