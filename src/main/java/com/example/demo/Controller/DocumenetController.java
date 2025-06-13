package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Document;
import com.example.demo.Entity.User;
import com.example.demo.Service.DocumenetService;

@RestController
@RequestMapping("/api/documents")
public class DocumenetController {

	    @Autowired
	    private DocumenetService documentService;

	    // Endpoint to upload a document
	    
	    @PostMapping("/upload")
	    public ResponseEntity<DocumentDTO > uploadDocument(@RequestBody Document document) {
	    	try {
	            Document uploadedDocument = documentService.uploadDocument(document);
	            DocumentDTO documentDTO = new DocumentDTO(uploadedDocument);
	            return ResponseEntity.ok(documentDTO);
	        } catch (Exception e) {
	            // Handle the exception appropriately
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	    }
	    
//	    @PostMapping("/upload")
//	    public ResponseEntity<Document> uploadDocument(@RequestBody Document document) {
//	        Document uploadedDocument = documentService.uploadDocument(document);
//	        return ResponseEntity.ok(uploadedDocument);
//	    }
	    // Endpoint to approve a document
//	    @PutMapping("/approve/{id}")
//	    public ResponseEntity<?> approveDocument(@PathVariable Long id) {
//	        try {
//	            Document document = documentService.approveDocument(id, id);
//	            return ResponseEntity.ok(document);
//	        } catch (DocumentNotFoundException e) {
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found");
//	        } catch (Exception e) {
//	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
//	        }
//	    }    
	    
	    // Endpoint to reject a document
	 
	        @PutMapping("/approve/{id}")
	    	public ResponseEntity<Document> approveDocument(@PathVariable Long id, @RequestParam Long userId) {
	            try {
	                Document approvedDocument = documentService.approveDocument(id, userId);
	                return ResponseEntity.ok(approvedDocument);
	            } catch (DocumentNotFoundException e) {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                                     .body(null); // You might want to return an error response here
	            } catch (Exception e) {
	                // Handle any other exceptions
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                                     .body(null);
	            }
	        }
	    @PutMapping("/reject/{id}")
	    public ResponseEntity<Document> rejectDocument(@PathVariable Long id) {
	        Document rejectedDocument = documentService.rejectDocument(id);
	        return ResponseEntity.ok(rejectedDocument);
	    }

	    // Endpoint to get documents for a user
	    @GetMapping("/user/{userId}")
	    public ResponseEntity<List<Document>> getUserDocuments(@PathVariable Long userId) {
	        User user = new User(); // Create user instance as needed (you might want to fetch it from the DB)
	        user.setId(userId);
	        List<Document> documents = documentService.getUserDocuments(user);
	        return ResponseEntity.ok(documents);
	    }
	    @GetMapping("/{documentId}")
	    public ResponseEntity<Document> getDocumentByIdAndUserId(
	            @PathVariable Long documentId,
	            @RequestParam Long userId) {
	        Document document = documentService.findByIdAndUserId(documentId, userId);
	        return ResponseEntity.ok(document);
	    }
	}

