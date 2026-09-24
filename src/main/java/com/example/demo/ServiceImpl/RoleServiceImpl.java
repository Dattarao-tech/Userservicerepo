package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.RoleService;

import jakarta.transaction.Transactional;

@Service
public class RoleServiceImpl implements RoleService{

	private static final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);
	@Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository; // Assuming you have a UserRepository

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    @Transactional
    @Override
    public  String assignRoleToUser(Long roleId, Long userId)  {

    	  Optional<User> optionalUser = userRepository.findById(userId);
    	    if (!optionalUser.isPresent()) {
    	        return "User with ID " + userId + " not found.";
    	    }

    	    Optional<Role> optionalRole = roleRepository.findById(roleId);
    	    if (!optionalRole.isPresent()) {
    	        return "Role with ID " + roleId + " not found.";
    	    }

    	    User user = optionalUser.get();
    	    Role role = optionalRole.get();

    	    // Add role only if it doesn't already exist
    	    if (!user.getRoles().contains(role)) {
    	        user.getRoles().add(role);
    	        userRepository.save(user);
    	        return "Role added successfully.";
    	    } else {
    	        return "User already has this role.";
    	    }
    	}

    @Override
    public void disableRole(Long roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow();
        // Logic to disable role
        role.setEnabled(false);
        roleRepository.save(role);
    }

	@Override
	public void modifyRole(Long roleId, Role role) {
		// TODO Auto-generated method stub

        Role existingRole = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found", null, roleId));

            existingRole.setName(role.getName());
            existingRole.setEnabled(role.isEnabled());
            roleRepository.save(existingRole);


	}

}

