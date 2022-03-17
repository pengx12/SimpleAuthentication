package com.example.service;

import java.util.HashSet;

import com.example.entity.Role;
public interface CheckRoleService
{
    
    public void addRoletoUser(String username, String rolename);

    public boolean checkRole(String token, Role role);

    public HashSet<Role> getAllRoles(String token);
}
