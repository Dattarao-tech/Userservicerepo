package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Document;
import com.example.demo.Entity.User;

public interface DocumentRepositoy extends JpaRepository<Document, Long>{

    List<Document> findByUser(User user);

	Optional<Document> findByIdAndUserId(Long documentId, Long userId);
	
    
}
