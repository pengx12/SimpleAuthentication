package com.example.entity;
import java.util.HashSet;

public class User {

    private HashSet<Role> roleList;

    private String userName;

    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.roleList=new HashSet<Role>();
    }


    public HashSet<Role> getRoleList() {
        return roleList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setpassword(String Password) {
        this.password = password;
    }

    // public void setRoleList(HashSet<Role> roleList) {
    //     this.roleList = roleList;
    // }


    public void addRole(Role role) {
        this.roleList.add(role);
    }

    public void deleteRole(Role role) {
        this.roleList.remove(role);
    }

    public boolean containsRole(Role role) {
        return this.roleList.contains(role);
    }
}
