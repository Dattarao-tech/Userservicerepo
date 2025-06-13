package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Event;
import com.example.demo.Entity.Registration;
import com.example.demo.Entity.User;
import com.example.demo.Projection.RegistrationProjection;
import com.example.demo.Repository.EventRepository;
import com.example.demo.Repository.RegistrationRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.RegistrationServcie;

@Service
public class Registrationserviceimpl  implements RegistrationServcie{
	
	   @Autowired
	   private RegistrationRepository registrationRepository;

	   @Autowired
	   private UserRepository userRepository;

	   @Autowired
	   private EventRepository  eventRepository;
	   
	   @Override
	    public Registration registerUserForEvent(Long userId, Long eventId) throws Exception {
		   System.out.println("Attempting registration for User ID: " + userId + ", Event ID: " + eventId);
		    
		    User user = userRepository.findById(userId)
		        .orElseThrow(() -> {
		            System.err.println("User with ID " + userId + " not found.");
		            return new IllegalArgumentException("User not found");
		        });
		    
		    Event event = eventRepository.findById(eventId)
		        .orElseThrow(() -> {
		            System.err.println("Event with ID " + eventId + " not found.");
		            return new IllegalArgumentException("Event not found");
		        });
		    
		    System.out.println("User and Event found. Checking registration...");

		    if (registrationRepository.findByUserAndEvent(user, event).isPresent()) {
		        System.err.println("User " + userId + " is already registered for Event " + eventId);
		        throw new Exception("User is already registered for this event");
		    }

		    // Create registration
		    Registration registration = new Registration();
		    registration.setUser(user);
		    registration.setEvent(event);
		    registration.setStatus("registered");
		    registration.setPassCode(generatePassForUser(registration.getId())); // Generate pass code

		    // Save registration
		    Registration savedRegistration = registrationRepository.save(registration);
		    System.out.println("Registration successful for User ID: " + userId + ", Event ID: " + eventId + ". Pass code: " + savedRegistration.getPassCode());

		    return savedRegistration;
	    }
	    @Override
	    public String generatePassForUser(Long registrationId) {
	        // Implement your logic for generating a pass
	        return UUID.randomUUID().toString(); // Simple UUID generation for the pass
	        
	    }
	}
	

