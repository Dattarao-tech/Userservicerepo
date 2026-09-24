package com.example.demo.Service;

import com.example.demo.Entity.User;

public interface OtpService {
	 String generateOTP(User user);
	 boolean validateOTP(User user, String otp);

}
