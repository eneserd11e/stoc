package com.enes.stock.dto;

import java.time.LocalDateTime;

public class LogDto {
	
	private Long id;
	private Long userId;
	private Long Quantity;
	private Boolean status;
	private String explanation;
	private LocalDateTime dateTime;


	public LogDto(Long id, Long userId, Long quantity, Boolean status, String explanation, LocalDateTime dateTime) {
		super();
		this.id = id;
		this.userId = userId;
		Quantity = quantity;
		this.status = status;
		this.explanation = explanation;
		this.dateTime = dateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getQuantity() {
		return Quantity;
	}

	public void setQuantity(Long quantity) {
		Quantity = quantity;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
