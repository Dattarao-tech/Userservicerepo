package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Registration;
import com.example.demo.Service.RegistrationServcie;

@RestController
@RequestMapping("/api")
public class RegistrationController {

	    @Autowired
	    private RegistrationServcie registrationService;

	    @PostMapping("/registration")
	    public ResponseEntity<Registration> registerUser(@RequestParam Long userId, @RequestParam Long eventId) {
	    	 try {
	    	        Registration registration = registrationService.registerUserForEvent(userId, eventId);
	    	        return ResponseEntity.status(HttpStatus.CREATED).body(registration);
	    	    } catch (IllegalArgumentException e) {
	    	        // Handle specific cases
	    	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // User or event not found
	    	    } catch (Exception e) {
	    	        // Log and handle general exceptions
	    	        System.err.println("Error during registration: " + e.getMessage());
	    	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	    	    }
	    }
	    @GetMapping("/generatePass")
	    public ResponseEntity<String> generatePassForUser(@RequestParam Long registrationId) {
	    	try {
	            String pass = registrationService.generatePassForUser(registrationId);
	            return ResponseEntity.ok(pass);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	    }
   }