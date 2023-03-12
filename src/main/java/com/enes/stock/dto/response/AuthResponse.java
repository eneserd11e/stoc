package com.enes.stock.dto.response;

public class AuthResponse {

	private Long id;
	private String name;
	private String message;
	private Boolean status;
	
	public AuthResponse() {}
	public AuthResponse(Long id, String name, String message,Boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public Boolean getStatus() {
		return this.status;
	}
}
