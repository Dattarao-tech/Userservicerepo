package com.example.demo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;



@SpringBootApplication
public class UserService1Application implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(UserService1Application.class, args);
	 }
	
	
	@Autowired
	private UserRepository  userRespository;
	
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		    Role adminRole = new Role(); 
//		    
////	        adminRole.setId(1L); 
//	        adminRole.setName("ROLE_ADMIN");
//	        adminRole.setEnabled(true);
//	        roleRepository.save(adminRole);
//////	        
//////
////	        
//	        Role userRole = new Role();
//////	        userRole.setId(2L);
//	        userRole.setName("ROLE_USER");
//	        userRole.setEnabled(true);
//	        roleRepository.save(userRole);
//		
//		 Set<Role> roles = new HashSet<>();
//	        roles.add(adminRole);
//	        roles.add(userRole);
//	        
//	        User user = new User();
//	        user.setUsername("dattaraodeosarkar4@gmail.com"); 
//	        user.setPassword("Dattarao"); 
//	        user.setEnabled(true); 
////	        user.setRoles(roles); 
//	        user.setOtp("123456"); 
//	        user.setOtpExpiration(LocalDateTime.now().plusMinutes(10)); 
//	        userRespository.save(user);
//	        System.out.println("User created: " + user);
		
	}
}
