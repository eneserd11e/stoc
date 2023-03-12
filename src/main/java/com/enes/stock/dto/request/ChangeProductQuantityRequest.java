package com.enes.stock.dto.request;

public class ChangeProductQuantityRequest {

	private Long id;
	private String name;
	private Long amount;
	
	public ChangeProductQuantityRequest() {}

	public ChangeProductQuantityRequest(Long id, String name, Long amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
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

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	
}
