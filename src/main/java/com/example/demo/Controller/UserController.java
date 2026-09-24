package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Service.UserService;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	    @Autowired
	    private UserService userService;

	    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<String> registerUser(@RequestBody User user) {
	        try {
	            User registeredUser = userService.registerUser(user);
	            return ResponseEntity.status(HttpStatus.CREATED)
	                                 .body("User registered successfully: " + registeredUser.getUsername());
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                                 .body("Registration failed: " + e.getMessage());
	        }
	    }
	    @GetMapping("/users")
	    public ResponseEntity<List<User>> getAllUsers() {
	        List<User>  users = userService.getAllUsers();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }
	    @GetMapping("/users/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	        User user = userService.getUserById(id);
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    }
	    @PutMapping("/users/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {

	    	try {
	            User updatedUser = userService.updateUser(id, user);
	            return ResponseEntity.ok(updatedUser);
	        } catch (ResourceNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body(null);
	        }
	    }
	    @DeleteMapping("/users/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	        userService.deleteUser(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<String> loginUser(@RequestBody User user) {
	        // Validate credentials
	        boolean isValid = userService.validateCredentials(user);

	        if (isValid) {
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        }
	}}

