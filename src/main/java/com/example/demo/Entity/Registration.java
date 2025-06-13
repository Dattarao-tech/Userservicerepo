package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "registrations")
public class Registration {
	
//	public Registration() {
//		// TODO Auto-generated constructor stub
//	   }
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id", nullable = false)
	    @JsonBackReference // Prevents serialization of the user reference
	    private User user;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "event_id", nullable = false)
	    @JsonBackReference // Prevents serialization of the event reference
	    private Event event;

	    private String status;
	    
	    private String passCode;
	    

	    @Override
	    public String toString() {
	        return "Registration{" +
	                "id=" + id +
	                ", userId=" + (user != null ? user.getId() : "N/A") +
	                ", eventId=" + (event != null ? event.getId() : "N/A") +
	                '}';
	    }
}