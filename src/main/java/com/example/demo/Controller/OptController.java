package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.OtpService;
import com.example.demo.Service.UserService;
import com.example.demo.ServiceImpl.LoginRequest;
import com.example.demo.ServiceImpl.OptResponse;
import com.example.demo.ServiceImpl.OtpRequest;
import com.example.demo.ServiceImpl.OtpValidationrequest;

@RestController
@RequestMapping("/api/auth")
public class OptController {
	
	     @Autowired
	    private OtpService otpService;
	     
	     @Autowired
	    private UserService userService;
	     
//	    @Autowired
//	    private OtpValidationrequest  request
	     OtpValidationrequest request = new  OtpValidationrequest(); 
	   
	     @PostMapping("/generate")
	     public ResponseEntity<String> generateOTP(@RequestBody User user) {
	         String otp = otpService.generateOTP(user);
	         return ResponseEntity.ok("OTP generated successfully: " + otp);
	     }
	     @PostMapping("/validate")
	     public ResponseEntity<String> validateOTP(@RequestBody OtpRequest request) {
	    	 System.out.println(request);
	    	 if (request.getOtp() == null || request.getOtp().isEmpty()) {
	    	        return ResponseEntity.badRequest().body("OTP is required");
	    	    }
	    	    // Here you can add your logic to validate the OTP
	    	    // For example, check if it matches the expected value

	    	    // If OTP is valid
	    	    return ResponseEntity.ok("OTP validated successfully");
	  }}
