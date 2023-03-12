package com.enes.stock.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name ="logs")
@Table(name = "log")
public class Log {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long userId;
	private Long amount;
	private Boolean status; // true add, false subsraction
	
	@Column(columnDefinition = "varchar(255)")
	private String explanation;
	@Column(name="createdAt")	
	private LocalDateTime dateTime;
	
	public Log() {}



	public Log(Long userId, Long amount, Boolean status, String explanation,LocalDateTime dateTime) {
		super();
		this.userId = userId;
		this.amount = amount;
		this.status = status;
		this.explanation = explanation;
		this.dateTime = dateTime;
	}

	public Log(Long id, Long userId, Long amount, Boolean status, String explanation, LocalDateTime dateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.amount = amount;
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

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
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
