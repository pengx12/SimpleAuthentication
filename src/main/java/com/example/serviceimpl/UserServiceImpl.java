package com.example.serviceimpl;

import com.example.entity.Role;
import com.example.entity.TokenPool;
import com.example.entity.User;
import com.example.entity.Users;
import com.example.service.UserService;
import com.example.util.ToolUtil;

public class UserServiceImpl implements UserService{

    private Users users;

    public UserServiceImpl(Users users){
        this.users=users;
    }
    
    public boolean addUser(String username, String password){
        if (users.containsUser(username))
        {
            return false;
        }
        else
        {
            users.addUser(password, username);
            return true;
        }
        
    }

    public boolean deleteUser(String username, TokenPool tokenpool){
        if (users.containsUser(username))
        {
            User user=users.getUserbyName(username);
            for (Role r : user.getRoleList()){
                r.removeUser(user);
            }
            users.removeUserbyName(username);
            tokenpool.removeToken(ToolUtil.generateToken(username));
            return true;
        }
        else
        {
            return false;
        }
        
    }
}
