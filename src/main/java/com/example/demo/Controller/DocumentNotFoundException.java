package com.example.demo.Controller;

public class DocumentNotFoundException extends RuntimeException{
	
	public DocumentNotFoundException(String massage) {
		super( massage);
		
	}
}
