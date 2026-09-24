package com.example.demo.Service;

import com.example.demo.Entity.Registration;

public interface RegistrationServcie {
	    Registration registerUserForEvent(Long userId, Long eventId) throws Exception;
	    String generatePassForUser(Long registrationId);
}
