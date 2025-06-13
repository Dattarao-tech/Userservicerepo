package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;

public interface RoleService {
	Role createRole(Role role);
    List<Role> getAllRoles();
    String assignRoleToUser(Long roleId, Long userId);
   void modifyRole(Long roleId, Role role);
    void disableRole(Long roleId);
    
    
}
