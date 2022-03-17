package com.example.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.entity.Roles;
import com.example.serviceimpl.RoleServiceImpl;

import org.junit.Test;

public class RoleServiceTest {
    
    private static Roles roles=new Roles();
    private static RoleService roleService=new RoleServiceImpl(roles);
    String rolename="editor";
    
    @Test
    public void testAddRole() {
        assertTrue(roleService.addRole(rolename)); // if not exists, add
        assertTrue(roles.containsRole(rolename)); //if exists, return false
    }

    @Test
    public void testDeleteRole() {
        roleService.addRole(rolename); 
        assertTrue(roleService.deleteRole(rolename)); // delete Role
        assertFalse(roles.containsRole(rolename)); //deleted successful
        assertFalse(roleService.deleteRole(rolename)); //if not exists, return false
    }
}
