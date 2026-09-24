package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Role;

public interface RoleService {
	Role createRole(Role role);
    List<Role> getAllRoles();
    String assignRoleToUser(Long roleId, Long userId);
   void modifyRole(Long roleId, Role role);
    void disableRole(Long roleId);


}
