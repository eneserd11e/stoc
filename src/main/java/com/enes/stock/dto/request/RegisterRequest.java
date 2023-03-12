package com.enes.stock.dto.request;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.sym.Name;

@Component
public class RegisterRequest {

	private String name;
	private String password;
	
	public RegisterRequest() {}

	public RegisterRequest(String name, String password) {
		super();
		this.name = name;
		this.password = password;
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
}
