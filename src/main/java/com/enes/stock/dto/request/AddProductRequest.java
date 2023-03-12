package com.enes.stock.dto.request;

public class AddProductRequest {

	private String name;
	private Long amount;
	private int categoryId;
	private String Location;
	
	public AddProductRequest(String name, Long amount, int categoryId, String location) {
		super();
		this.name = name;
		this.amount = amount;
		this.categoryId = categoryId;
		Location = location;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}
}
