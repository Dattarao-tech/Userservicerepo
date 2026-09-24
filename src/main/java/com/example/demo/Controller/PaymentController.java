package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Payment;
import com.example.demo.Service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	@Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> processPayment(
            @RequestParam Long userId,
            @RequestParam Double amount,
            @RequestParam String paymentMethod) {
        try {
            Payment payment = paymentService.processPayment(userId, amount, paymentMethod);
            return ResponseEntity.status(HttpStatus.CREATED).body(payment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<Payment>> getPaymentsByUser(@PathVariable Long userId) {
    	    try{
    	        List<Payment> payments = paymentService.getPaymentsByUser(userId);
    	        System.out.println("Retrieved payments for user ID: " + userId + " - " + payments);

    	        if (payments.isEmpty()) {
    	            System.out.println("No payments found for user ID: " + userId);
    	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(payments);
    	        }
    	        return ResponseEntity.ok(payments);

    	    } catch (Exception e) {
    	        System.out.println("Error retrieving payments for user ID " + userId + ": " + e.getMessage());
    	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    	    }
        }
     }
