package com.example.demo.Entity;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    
	    @Column(unique = true)
	    private String username;
	    
	    
	    private String password;

	    private boolean enabled;

	    @ManyToMany
	    private Set<Role> roles;

	    private String otp;

	    private LocalDateTime otpExpiration;

//	    @OneToMany(mappedBy = "user")
//	    private Set<Registration> registrations;

	    
	    @Override
	    public String toString() {
	        return "User{" +
	                "id=" + id +
	                ", username='" + username + '\'' +
	                ", enabled=" + enabled +
	                ", roleCount=" + (roles != null ? roles.size() : 0) +
	                '}';
	    }

	
	}

