package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceimpl implements UserService{

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Override
	    @Transactional
	    public User registerUser(User user) throws UserAlreadyExistsException   {

	        // Validate that username and password are not null
	        if (user.getUsername() == null || user.getPassword() == null) {
	            throw new IllegalArgumentException("Username and password must not be null");
	        }

	        // Check if the user already exists by username
	        if (userRepository.findByUsername(user.getUsername()) != null) {
	            throw new UserAlreadyExistsException("User already exists with username: " + user.getUsername());
	        }

	        // Hash the password before saving (ensure using BCrypt)
	        String hashedPassword = passwordEncoder.encode(user.getPassword());
	        user.setPassword(hashedPassword);

	        // Save and return the user
	        return userRepository.save(user);
	    }

	    @Override
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    @Override
	    public User getUserById(Long id) {
	        return userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
	    }
	    @Override
	    public User updateUser(Long id, User user) {
	    	User existingUser = userRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("User not found", null, id));
	        existingUser.setUsername(user.getUsername());
	        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
	            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
	        }
	        existingUser.setEnabled(user.isEnabled());
	        existingUser.setRoles(user.getRoles());
	        existingUser.setOtp(user.getOtp());
	        existingUser.setOtpExpiration(user.getOtpExpiration());
	        return userRepository.save(existingUser);
	    }
	    @Override
	    public void deleteUser(Long id) {
	        if (!userRepository.existsById(id)) {
	            throw new RuntimeException("User not found with ID: " + id);
	        }
	        userRepository.deleteById(id);
	    }
		@Override
		public User findByUsername(String username) {
			// TODO Auto-generated method stub
			User byUsername = userRepository.findByUsername(username);
			return userRepository.save(byUsername);
		}
		@Override
		public boolean validateCredentials(User user) {
			// TODO Auto-generated method stub
			User foundUser = userRepository.findByUsername(user.getUsername());
	        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
	            return true;
	        }
	        return false;
		}
	}