package com.enes.stock.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private long amount;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="categoryId",nullable = false)
	private Category categoryId;
	
	@Column(columnDefinition = "varchar(255)")
	private String location;
	
	
	
	public Product () {}


	public Product(String name, long amount, Category categoryId, String location) {
		super();
		this.name = name;
		this.amount = amount;
		this.categoryId = categoryId;
		this.location = location;
	}


	public Product(Long id, String name, long amount, Category categoryId, String location) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.categoryId = categoryId;
		this.location = location;
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

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public Category getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
