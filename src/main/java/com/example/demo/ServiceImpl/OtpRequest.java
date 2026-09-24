package com.example.demo.ServiceImpl;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class OtpRequest {
	private String username;
    private String otp;
	public boolean validateOtp(String username2, String otp2) {
		// TODO Auto-generated method stub
		return false;
	}

}
