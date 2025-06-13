package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Payment;
import com.example.demo.Entity.User;
import com.example.demo.Repository.PaymentRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	
	    @Autowired
	    private PaymentRepository paymentRepository;
	    
	    @Autowired
	    private UserRepository userRepository;

	    @Override
	    public Payment processPayment(Long userId, Double amount, String paymentMethod) {
	        User user = userRepository.findById(userId)
	            .orElseThrow(() -> new IllegalArgumentException("User not found"));

	        Payment payment = new Payment();
	        
	        payment.setAmount(amount);
	        
	        payment.setPaymentMethod(paymentMethod);
	        
	        payment.setStatus("completed");
	        payment.setUser(user);
	       
	        return paymentRepository.save(payment);
	    }

		@Override
		public List<Payment> getPaymentsByUser(Long userId) {
			// TODO Auto-generated method stu	
			List<Payment> payments = paymentRepository.findByUserId(userId);
		    System.out.println("Payments for userId " + userId + ": " + payments);
		    return payments;   
		}
   }
