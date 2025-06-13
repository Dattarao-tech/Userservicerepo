package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Document;
import com.example.demo.Entity.User;

public interface DocumenetService {
	 Document uploadDocument(Document document);
//	    Document approveDocument(Long documentId);  // Ensure this returns Document
	    Document rejectDocument(Long documentId);   // Ensure this returns Document
	    List<Document> getUserDocuments(User user);
	    Document findByIdAndUserId(Long documentId, Long userId);
	    Document approveDocument(Long documentId, Long userId);
 }
