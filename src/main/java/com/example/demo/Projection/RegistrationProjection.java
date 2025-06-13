package com.example.demo.Projection;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public interface RegistrationProjection {
	Long getId();
    Long getUserId();
    Long getEventId();
    String getStatus();
}
