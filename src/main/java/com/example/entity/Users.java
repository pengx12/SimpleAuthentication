package com.example.entity;

import java.util.HashSet;

import com.example.util.ToolUtil;

public class Users {

    private HashSet<User> users;

    private HashSet<String> names;

    public Users() {
        this.users = new HashSet<User> ();
        this.names = new HashSet<String> ();
    }
    

    public boolean containsUser(String name) {
        return names.contains(name);
    }

    public User getUserbyName(String name) {
        
        for (User user : users){
            if (user.getUserName()==name){
                return user;
            }
        }
        return null;
    }

    public void removeUserbyName(String name) {
        for (User user : users){
            if (user.getUserName()==name){
                users.remove(user);
                names.remove(name);
            }
        }
    }

    public void addUser(String password,String userName){
        String encpassword=ToolUtil.generateEncPassword(password);
            
        users.add(new User(userName, encpassword));
        names.add(userName);
    }
    
}
