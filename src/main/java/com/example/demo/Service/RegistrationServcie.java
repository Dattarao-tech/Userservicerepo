package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Registration;
import com.example.demo.Projection.RegistrationProjection;

public interface RegistrationServcie {
	    Registration registerUserForEvent(Long userId, Long eventId) throws Exception;
	    String generatePassForUser(Long registrationId);
}
