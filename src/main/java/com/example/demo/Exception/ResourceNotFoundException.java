package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fileName;
	private String fieldValue;

	public ResourceNotFoundException(String resourceName, String fileName, Long id) {
		super(String.format("%s not found with %s :'%s'", resourceName,fileName,id));
		this.resourceName = resourceName;
		this.fileName = fileName;
		this.fieldValue = fieldValue;

	}
	public ResourceNotFoundException(String string) {
		// TODO Auto-generated constructor stub
	}

	public String getResourceName() {
		return resourceName;
	}
	public String getFileName() {
		return fileName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
}
