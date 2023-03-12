package com.enes.stock.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enes.stock.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Optional<Product> findByName(String name);
	
	List<Product> findByCategoryId(Integer categoryId);
}
