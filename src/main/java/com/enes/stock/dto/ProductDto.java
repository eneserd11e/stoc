package com.enes.stock.dto;

import com.enes.stock.model.Category;

public class ProductDto {

	private Long id;
	private String name;
	private Long amount;
	private Category categoryId;
	private String Location;
	
	public ProductDto() {}

	public ProductDto( String name, Long amount, Category categoryId, String location) {
		super();
		
		this.name = name;
		this.amount = amount;
		this.categoryId = categoryId;
		Location = location;
	}




	public ProductDto(Long id, String name, Long amount, Category categoryId, String location) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.categoryId = categoryId;
		Location = location;
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

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}
	
}
