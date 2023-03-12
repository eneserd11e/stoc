package com.enes.stock.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.enes.stock.dto.ProductDto;
import com.enes.stock.dto.converter.ProductDtoConverter;
import com.enes.stock.dto.request.AddProductRequest;
import com.enes.stock.dto.request.ChangeProductQuantityRequest;
import com.enes.stock.exception.ProductIsAvailableException;
import com.enes.stock.exception.ProductNotFoundException;
import com.enes.stock.exception.ProductQuantityCannnotBeNegativeException;
import com.enes.stock.model.Category;
import com.enes.stock.model.Product;
import com.enes.stock.repository.ProductRepository;



@Service
public class ProductService {

	
	private final ProductRepository productRepository;
	private final ProductDtoConverter  productDtoConverter;
	private final CategoryService categoryService;
	
	public ProductService(ProductRepository productRepository, ProductDtoConverter productDtoConverter,
			CategoryService categoryService) {
		super();
		this.productRepository = productRepository;
		this.productDtoConverter = productDtoConverter;
		this.categoryService = categoryService;
	}





	public Boolean addProduct(AddProductRequest newProduct) {
		
		if (productRepository.findByName(newProduct.getName()).isPresent())  throw new ProductIsAvailableException("Product already exists!!!");
		
		if (newProduct.getAmount() <= 0) new ProductQuantityCannnotBeNegativeException("Amount Cannot Be negative");
		Category category = categoryService.getOneCategory(newProduct.getCategoryId());
		productRepository.save(new Product(
				newProduct.getName(),
				newProduct.getAmount(),
				category,
				newProduct.getLocation()));
		
		return true;
		
	}
	
	public ProductDto reduceQuantity(ChangeProductQuantityRequest productRequest) {
		
		Product  product = productRepository.findByName(productRequest.getName()).orElseThrow(() -> new ProductNotFoundException("Proudct Not Found"));
		
		if(product.getAmount() - productRequest.getAmount() <= 0) throw new ProductQuantityCannnotBeNegativeException("Quantity cannot be negative");
		
		product.setAmount(product.getAmount() - productRequest.getAmount());
		return productDtoConverter.convert(productRepository.save(product));
		
	}
	
	public ProductDto addQuantity(ChangeProductQuantityRequest productRequest) {
		
		Product  product = productRepository.findByName(productRequest.getName()).orElseThrow(() -> new ProductNotFoundException("Proudct Not Found"));
		product.setAmount(product.getAmount() + productRequest.getAmount());
		return productDtoConverter.convert(productRepository.save(product));
	}
	
	
	
	public List<ProductDto> getproductList(){
		
		List<Product> productList = productRepository.findAll();
	
		return productList.stream().map(product -> productDtoConverter.convert(product)).collect(Collectors.toList());
		
		
		
	}
	
	public boolean updateProduct(ProductDto productRequest) {
		Product  product = productRepository.findByName(productRequest.getName()).orElseThrow(() -> new ProductNotFoundException("Proudct Not Found"));
		if(productRequest.getCategoryId().getId() != 0) 
			product.setCategoryId(null);
		if(productRequest.getLocation() != null)
			product.setLocation(productRequest.getLocation());
		if(productRequest.getName() != null)
			product.setName(productRequest.getName());
		productRepository.save(product);
		return true;
	}
	
	public boolean deleteProduct(Long productId) {
		Product  product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Proudct Not Found"));
		productRepository.deleteById(productId);
		return true;
	}
	
	public List<ProductDto> getProductByCategoryId(Integer categoryId){
		
		return  productRepository.findByCategoryId(categoryId)
				.stream()
				.map(product -> productDtoConverter.convert(product))
				.collect(Collectors.toList());
	}
	
}
