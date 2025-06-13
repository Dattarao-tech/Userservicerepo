package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Controller.DocumentNotFoundException;
import com.example.demo.Entity.Document;
import com.example.demo.Entity.User;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.DocumentRepositoy;
import com.example.demo.Service.DocumenetService;

@Service
public class DocumentServiceImpl implements DocumenetService{
	    @Autowired
	    private DocumentRepositoy documentRepository;

	    @Override
	    public Document uploadDocument(Document document) {
	        return documentRepository.save(document);
	    }
//	     @Override
//	   	 public Document approveDocument(Long documentId) {
//	   	        Document document = documentRepository.findById(documentId)
//	   	            .orElseThrow(() -> new ResourceNotFoundException("Document not found", null, documentId)); // Add appropriate exception handling
//	   	        document.setStatus("Approved");
//	   	        return documentRepository.save(document);
//	    }
	 
	    @Override
	    public Document rejectDocument(Long documentId) {
	        Document document = documentRepository.findById(documentId)
	            .orElseThrow(() -> new ResourceNotFoundException("Document not found", null, documentId)); // Add appropriate exception handling
	        document.setStatus("Rejected");
	        return documentRepository.save(document);
	    }

	    @Override
	    public List<Document> getUserDocuments(User user) {
	        return documentRepository.findByUser(user);
	    }

		@Override
		public Document findByIdAndUserId(Long documentId, Long userId) {
			// TODO Auto-generated method stub
			return documentRepository.findByIdAndUserId(documentId, userId)
		            .orElseThrow(() -> new DocumentNotFoundException("Document not found with ID: " + documentId + " for user: " + userId));
		}
		@Override
		public Document approveDocument(Long documentId, Long userId) {
			// TODO Auto-generated method stub
			Document document = findByIdAndUserId(documentId, userId);
		    
		    if (document == null) {
		        throw new DocumentNotFoundException("Document not found for ID: " + documentId);
		    }
		    // Check if document can be approved
		    if ("Approved".equals(document.getStatus())) {
		        throw new IllegalStateException("Document is already approved.");
		    }
		    // Change status to Approved
		    document.setStatus("Approved");		    
		    try {
		        return documentRepository.save(document);
		    } catch (Exception e) {
		        throw new RuntimeException("Error saving the document: " + e.getMessage(), e);
		    }
		}
	}

	    

