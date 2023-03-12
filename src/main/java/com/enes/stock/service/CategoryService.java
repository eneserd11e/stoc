package com.enes.stock.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.enes.stock.dto.CategoryDto;
import com.enes.stock.dto.converter.CategoryDtoConverter;
import com.enes.stock.exception.CategoryIsAvailableException;
import com.enes.stock.exception.CategoryNotFoundException;
import com.enes.stock.model.Category;
import com.enes.stock.repository.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;
	private final CategoryDtoConverter categoryDtoConverter;
	

	
	public CategoryService(CategoryRepository categoryRepository, CategoryDtoConverter categoryDtoConverter) {
		super();
		this.categoryRepository = categoryRepository;
		this.categoryDtoConverter = categoryDtoConverter;
	}


	public List<CategoryDto> getListCategory() {
		return categoryRepository.findAll().stream().map(category -> categoryDtoConverter.convert(category)).collect(Collectors.toList());
	}
	
	public Boolean addCategory(String category) {
		categoryRepository.findBycategoryName(category).orElseThrow(()-> new CategoryIsAvailableException("category already added"));
		categoryRepository.save(new Category(category));
		return true;
	}
	
	public Boolean deleteCategory(Integer categoryId) {
		categoryRepository.findById(categoryId).orElseThrow(()-> new CategoryIsAvailableException("category alreadyu added"));
		categoryRepository.deleteById(categoryId);
		return true;
	}
	
	protected Category getOneCategory (Integer categoryId) {
		return categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category Not Found"));
	}
	
}
