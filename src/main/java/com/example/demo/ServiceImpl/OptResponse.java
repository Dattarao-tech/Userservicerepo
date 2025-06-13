package com.example.demo.ServiceImpl;

import jakarta.annotation.Nonnull;
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
public class OptResponse {
	private String message;
    private boolean success;
}
