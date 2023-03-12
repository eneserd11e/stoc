package com.enes.stock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enes.stock.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {


	
	Optional<Category> findBycategoryName(String categoryName);
}
