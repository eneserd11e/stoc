package com.enes.stock.dto.request;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.sym.Name;

@Component
public class RegisterRequest {

	private String name;
	private String password;
	private String confirmPassword;
	
	
	public RegisterRequest() {}

	public RegisterRequest(String name, String password,String confirmPassword) {
		super();
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
}
