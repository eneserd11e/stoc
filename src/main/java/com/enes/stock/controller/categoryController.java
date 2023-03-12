package com.enes.stock.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enes.stock.dto.CategoryDto;
import com.enes.stock.service.CategoryService;

@RestController
@RequestMapping("v1/category/")
public class categoryController {

	private final CategoryService categoryService;

	public categoryController(CategoryService categoryService) {
		
		this.categoryService = categoryService;
	}
	
	@GetMapping("getList")
	public ResponseEntity<List<CategoryDto>> getCategoryList(){
		return ResponseEntity.ok(categoryService.getListCategory());
	}
	
	@PostMapping("add/{categoryName}")
	public ResponseEntity<Boolean> addCategory(@PathVariable String categoryName){
		return ResponseEntity.ok(categoryService.addCategory(categoryName));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Boolean> deleteCategory(@PathVariable Integer id){
		return ResponseEntity.ok(categoryService.deleteCategory(id));
	}
	
}
