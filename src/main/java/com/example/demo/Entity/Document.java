package com.example.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
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

@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="documet")
public class Document {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;
    private String status; // e.g., "Pending", "Approved", "Rejected"

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    

    private LocalDateTime uploadDate;
    public Document() {
		// TODO Auto-generated constructor stub
	}
}
