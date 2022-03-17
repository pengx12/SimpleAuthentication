package com.example.service;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.entity.Role;
import com.example.entity.Roles;
import com.example.entity.TokenEntity;
import com.example.entity.TokenPool;
import com.example.entity.Users;
import com.example.serviceimpl.AuthenticateServiceImpl;
import com.example.serviceimpl.CheckRoleServiceImpl;
import com.example.serviceimpl.RoleServiceImpl;
import com.example.serviceimpl.UserServiceImpl;
import com.example.util.DefinedConstant;


public class CheckRoleServiceTest {

    private static Users users=new Users();
    private static Roles roles=new Roles();
    private static TokenPool tokenpool=new TokenPool();
    private static RoleService roleService=new RoleServiceImpl(roles);
    private static UserService userService=new UserServiceImpl(users);
    private static CheckRoleService checkRoleService=new CheckRoleServiceImpl(tokenpool, users, roles);
    private static AuthenticateService authService=new AuthenticateServiceImpl(users, tokenpool);

    private static String username="admin";
    private static String password="123456";
    private static String rolename="editor";
    private static String token="";
    
    @BeforeClass
    public static void beforeAll() {
        userService.addUser(username, password);
        roleService.addRole(rolename); 
        
        
    }

    @Test
    public void testAddRoletoUser() {
        checkRoleService.addRoletoUser(username, rolename);
        assertEquals("After adding, the user now has 1 role", 1, users.getUserbyName(username).getRoleList().size());
        checkRoleService.addRoletoUser(username, rolename);
        assertEquals("Nothing happens, the user still has 1 role", 1, users.getUserbyName(username).getRoleList().size());
    }

    @Test
    public void testCheckRole() {
        token=authService.authenticate(username,password);
        Role role=roles.getRolebyName(rolename);
        // assertFalse(checkRoleService.checkRole(token, role));
        checkRoleService.addRoletoUser(username, rolename);
        assertTrue(checkRoleService.checkRole(token, role));
        assertFalse(checkRoleService.checkRole(DefinedConstant.Error_Message, role));
        TokenEntity tokenent=tokenpool.getToken(token);
        //to check token expiry 
        tokenent.setLastAuthTime(System.currentTimeMillis()-DefinedConstant.Token_Expire_Time-1);
        assertFalse(checkRoleService.checkRole(token, role));
    }

    @Test
    public void testGetAllRoles() {
        token=authService.authenticate(username,password);
        checkRoleService.addRoletoUser(username, rolename);
        assertEquals("the user now has 1 role", 1, checkRoleService.getAllRoles(token).size());
        assertEquals("the token is invalid", null, checkRoleService.getAllRoles(DefinedConstant.Error_Message));
        TokenEntity tokenent=tokenpool.getToken(token);
        //to check token expiry 
        tokenent.setLastAuthTime(System.currentTimeMillis()-DefinedConstant.Token_Expire_Time-1);
        assertEquals("the token is invalid", null, checkRoleService.getAllRoles(token));


    }
}
