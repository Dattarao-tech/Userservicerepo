package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	 private final CutomeUserDetailsService customUserDetailsService;

	    // Inject CustomUserDetailsService through constructor (recommended over field injection)
	    public SecurityConfig(CutomeUserDetailsService customUserDetailsService) {
	        this.customUserDetailsService = customUserDetailsService;
	    }
	    
	    // Configure HTTP security
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	            .authorizeRequests()
	                // Public endpoints (no authentication required)
	                .requestMatchers("/api/users/register", "/api/users/login", "/api/event", "/error")
	                .permitAll()
	                // Authenticated endpoints (authentication required)
	                .requestMatchers("/api/order/**", "/api/registration/**", "/api/users/**", "/api/items/**")
	                .authenticated()
	                // Any other request requires authentication
	                .anyRequest().authenticated()
	            .and()
	            .httpBasic();  // Enable basic authentication

//	    	http.csrf().disable()
//            .authorizeRequests()
//                // Make /api/users endpoint public
//                .requestMatchers("/api/users/**").permitAll()  // Allow public access to /api/users
//                // Make other endpoints secure (authentication required)
//                .anyRequest().authenticated()
//            .and()
//            .httpBasic();  // You can remove this if you don't want any security

        return http.build();
	    
	    }

	    // Password encoder bean for encoding passwords
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();  // Use BCrypt for password encoding
	    }

	    // UserDetailsService bean to use the custom service for user authentication
	    @Bean
	    public UserDetailsService userDetailsService() {
	        return customUserDetailsService;  // Use the custom UserDetailsService
	    }

	    // DaoAuthenticationProvider for handling authentication
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder) {
	        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	        provider.setUserDetailsService(customUserDetailsService);  // Set the custom user details service
	        provider.setPasswordEncoder(passwordEncoder);  // Set the password encoder
	        return provider;
	    }
	}


 