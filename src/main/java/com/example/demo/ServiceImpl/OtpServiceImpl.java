package com.example.demo.ServiceImpl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Service.OtpService;

@Service
public class OtpServiceImpl implements OtpService{

	    private static final int OTP_EXPIRY_MINUTES = 5; // Set OTP expiration time
	    private Map<String, OtpData> otpStore = new HashMap<>();

	    @Autowired
	    private JavaMailSender emailSender;

	    @Override
	    public String generateOTP(User user) {
	        // Generate a random 6-digit OTP
	        String otp = String.format("%06d", (int) (Math.random() * 1000000));

	        // Store the OTP with its expiry time
	        OtpData otpData = new OtpData(otp, LocalDateTime.now().plusMinutes(OTP_EXPIRY_MINUTES));
	        otpStore.put(user.getUsername(), otpData);

	        // Send the OTP via email
	        sendEmail(user.getUsername(), otp);
	        return otp;
	    }

	    private void sendEmail(String to, String otp) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject("Your OTP Code");
	        message.setText("Your OTP code is: " + otp);
	        emailSender.send(message);
	    }

	    @Override
	    public boolean validateOTP(User user, String otp) {
	        // Retrieve the stored OTP for the user
	        OtpData otpData = otpStore.get(user.getUsername());

	        // Check if the OTP exists
	        

	        // Check if the OTP is expired
	        // Compare the provided OTP with the stored OTP
	        if ((otpData == null) || otpData.getExpiryTime().isBefore(LocalDateTime.now()) || !otpData.getOtp().equals(otp)) {
	            return false; // OTP does not match
	        }

	        // OTP is valid and not expired
	        return true;
	    }

	    // Inner class to hold OTP and its expiry time
	    private static class OtpData {
	        private String otp;
	        private LocalDateTime expiryTime;

	        public OtpData(String otp, LocalDateTime expiryTime) {
	            this.otp = otp;
	            this.expiryTime = expiryTime;
	        }

	        public String getOtp() {
	            return otp;
	        }

	        public LocalDateTime getExpiryTime() {
	            return expiryTime;
	        }
	    }
	}


