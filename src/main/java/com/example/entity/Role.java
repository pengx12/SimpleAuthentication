package com.example.entity;

import java.util.HashSet;

public class Role {
    
    // private User user;

    private String name;
    private HashSet<User> userset=new HashSet<User>();

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  HashSet<User> getUserSet() {
        return this.userset;
    }

    public void addUser(User user) {
        this.userset.add(user);
    }  
    
    public void removeUser(User user) {
        this.userset.remove(user);
    }





}
