package com.enes.stock.dto;

public class CategoryDto {

	private Integer id;
	private String categoryName;
	
	public CategoryDto() {}
	
	public CategoryDto(Integer id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
}
