package com.example.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Role;
import com.example.demo.Service.RoleService;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	private static final Logger log = LoggerFactory.getLogger(RoleController.class);

	    @Autowired
	    private RoleService roleService;

	    @Autowired
	   private UserService userService;

	    @PostMapping
	    public ResponseEntity<Role> createRole(@RequestBody Role role) {
	        Role createdRole = roleService.createRole(role);
	        return ResponseEntity.ok(createdRole);
	    }

	    @GetMapping
	    public ResponseEntity<List<Role>> getAllRoles() {
	        List<Role> roles = roleService.getAllRoles();
	        return ResponseEntity.ok(roles);
	    }
	    @PutMapping("/{id}")
	    public ResponseEntity<Void> updateRole(@PathVariable Long id, @RequestBody Role role) {
	        roleService.modifyRole(id, role);
	        return ResponseEntity.noContent().build(); // Return 204 No Content
	    }

	    @PutMapping("/{roleId}/disable")
	    public ResponseEntity<Void> disableRole(@PathVariable Long roleId) {
	        roleService.disableRole(roleId);
	        return ResponseEntity.noContent().build();
	    }
	    @PostMapping("/{roleId}/assign/{userId}")
	    public ResponseEntity<String> assignRoleToUser(@PathVariable Long userId, @PathVariable Long roleId) {
	        String result = roleService.assignRoleToUser(roleId, userId);
	        return ResponseEntity.ok(result);
	    }
	}

