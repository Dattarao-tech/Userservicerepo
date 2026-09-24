package com.example.demo.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{


	@Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/api/**")  // Allow CORS for all API endpoints
//
//
//                .allowedOrigins("http://localhost:4200")  // Angular frontend
//                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow specific methods
//                .allowedHeaders("*")  // Allow all headers
//                .allowCredentials(true);
//		registry.addMapping("/**").allowedOrigins("http://localhost:4200");
		   registry.addMapping("/**")
           .allowedOrigins("http://localhost:4200")  // Allow requests from Angular app
           .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow these HTTP methods
           .allowedHeaders("*")  // Allow all headers
           .allowCredentials(true);  //
	}
}
