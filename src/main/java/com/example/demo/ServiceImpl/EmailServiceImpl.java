package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.Service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

	    @Autowired
	    private JavaMailSender emailSender;

	 @Override
	public void sendEmail(String to, String subject, String body) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(body);
	        emailSender.send(message);
	        emailSender.send(message); // Send the email
	        System.out.println("Email sent to: " + to);
	   }
}
