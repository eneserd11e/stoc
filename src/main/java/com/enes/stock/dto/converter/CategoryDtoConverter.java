package com.enes.stock.dto.converter;

import org.springframework.stereotype.Component;

import com.enes.stock.dto.CategoryDto;
import com.enes.stock.model.Category;

@Component
public class CategoryDtoConverter {
	
	public CategoryDto convert(Category category) {
		return new CategoryDto(category.getId()
				,category.getCategoryName());
	}
}
