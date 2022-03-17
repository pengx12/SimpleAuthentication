package com.example.serviceimpl;

import java.util.HashSet;

import com.example.entity.Role;
import com.example.entity.Roles;
import com.example.entity.TokenEntity;
import com.example.entity.TokenPool;
import com.example.entity.User;
import com.example.entity.Users;
import com.example.service.CheckRoleService;
import com.example.util.DefinedConstant;
import com.example.util.ToolUtil;

public class CheckRoleServiceImpl implements CheckRoleService{

    private TokenPool tokenpool;
    private Users users;
    private Roles roles;


    public CheckRoleServiceImpl(TokenPool tokenpool,Users users, Roles roles){
        this.tokenpool=tokenpool;
        this.users=users;
        this.roles=roles;
    }

    public void addRoletoUser(String username, String rolename){
        User user=this.users.getUserbyName(username);
        Role role=this.roles.getRolebyName(rolename);
        if (user!=null && role!=null)
        {
            user.addRole(role);
            role.addUser(user);
        }
    }

    public boolean checkRole(String token, Role role){
        TokenEntity tokenent=this.tokenpool.getToken(token);
        if (tokenent!=null){
            if (ToolUtil.checkExpiration(DefinedConstant.Token_Expire_Time,tokenent.getLastAuthTime()))
            {
                User user=tokenent.getUser();
                if (user.containsRole(role))
                {
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                this.tokenpool.removeToken(token);
            }
        }
        return false;
    }

    public HashSet<Role> getAllRoles(String token){

        TokenEntity tokenent=this.tokenpool.getToken(token);
        if (tokenent!=null){
            if (ToolUtil.checkExpiration(DefinedConstant.Token_Expire_Time,tokenent.getLastAuthTime()))
            {
                User user=tokenent.getUser();
                return user.getRoleList();
            }
            else{
                this.tokenpool.removeToken(token);
            }
        }
        return null;
    }
}
