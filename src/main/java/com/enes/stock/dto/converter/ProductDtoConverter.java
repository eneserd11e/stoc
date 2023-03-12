package com.enes.stock.dto.converter;

import org.springframework.stereotype.Component;

import com.enes.stock.dto.CategoryDto;
import com.enes.stock.dto.ProductDto;
import com.enes.stock.model.Category;
import com.enes.stock.model.Product;

@Component
public class ProductDtoConverter {
	
	private final CategoryDtoConverter categoryDtoConverter;
	
	public ProductDtoConverter(CategoryDtoConverter categoryDtoConverter) {
		super();
		this.categoryDtoConverter = categoryDtoConverter;
	}

	public ProductDto convert(Product product) {
		CategoryDto category = categoryDtoConverter.convert(product.getCategoryId());
		
		return new ProductDto(product.getId(),
				product.getName(),
				product.getAmount(),
				product.getCategoryId(),
				product.getLocation());
	}
}
