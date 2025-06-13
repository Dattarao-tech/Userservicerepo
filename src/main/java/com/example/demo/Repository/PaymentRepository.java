package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Payment;
import com.example.demo.Entity.User;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
	List<Payment> findByUser(User user);

	List<Payment> findByUserId(Long userId);
}
