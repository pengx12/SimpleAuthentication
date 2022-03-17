package com.example.serviceimpl;


import com.example.entity.Role;
import com.example.entity.Roles;
import com.example.entity.User;
import com.example.service.RoleService;

public class RoleServiceImpl implements RoleService{

    private Roles roles;
    public RoleServiceImpl( Roles roles){
        this.roles=roles;
    }
    
    public boolean addRole(String name){
        if (this.roles.containsRole(name))
        {
            return false;
        }
        else
        {
            this.roles.addRole(name);
            return true;
        }
        
    }

    public boolean deleteRole(String name){
        if (this.roles.containsRole(name))
        {
            Role role=this.roles.getRolebyName(name);
            for (User user : role.getUserSet()){
                user.deleteRole(role);
            }
            this.roles.removeRolebyName(name);
            return true;
        }
        else
        {
            return false;
        }
        
    }

    
}
