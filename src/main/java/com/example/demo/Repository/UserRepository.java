package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;

public interface UserRepository extends JpaRepository <User, Long>{
	  
//	@Query("SELECT u FROM users u WHERE u.username = :username")
//	  User findByUsername( @Param("username")  String username);
//	  
	User findByUsername(String username);
	  void save(Role adminRole);
	  Optional<User> findById(Long id);
//	  User findByUsername(String email);
	  boolean existsByUsername(String username);
	  

	  
	  
}
