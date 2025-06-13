package com.example.demo.Security;

public class RoleNotFoundException extends RuntimeException{

	public RoleNotFoundException(String message) {
        super(message);
    }
}
