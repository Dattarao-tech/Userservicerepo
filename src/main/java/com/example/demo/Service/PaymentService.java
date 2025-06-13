package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Payment;

public interface PaymentService {
	 Payment processPayment(Long userId, Double amount, String paymentMethod);
	 List<Payment> getPaymentsByUser(Long userId);
	 
}
