package com.example.entity;

import java.util.HashSet;

public class Roles {
    private HashSet<Role> roles;

    private HashSet<String> names;

    public Roles() {
        this.roles = new HashSet<Role> ();
        this.names = new HashSet<String> ();
    }
    public boolean containsRole(String name) {
        return names.contains(name);
    }

    public Role getRolebyName(String name) {
        
        for (Role user : roles){
            if (user.getName()==name){
                return user;
            }
        }
        return null;
    }

    public void removeRolebyName(String name) {
        for (Role user : roles){
            if (user.getName()==name){
                roles.remove(user);
                names.remove(name);
            }
        }
    }

    public void addRole(String rolename){
        roles.add(new Role(rolename));
        names.add(rolename);
    }

}
