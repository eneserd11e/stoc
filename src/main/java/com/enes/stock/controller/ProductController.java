package com.enes.stock.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enes.stock.dto.ProductDto;
import com.enes.stock.dto.request.AddProductRequest;
import com.enes.stock.dto.request.ChangeProductQuantityRequest;
import com.enes.stock.service.ProductService;

@RestController
@RequestMapping("v1/product")
public class ProductController {

	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Boolean> addProdcut(@RequestBody AddProductRequest product) {
		
		return ResponseEntity.ok(productService.addProduct(product));
	}
	
	@PutMapping("/addQuantity")
	public ResponseEntity<ProductDto> addQuantity(@RequestBody ChangeProductQuantityRequest request) {
		return ResponseEntity.ok(productService.addQuantity(request));
	}
	
	@PutMapping("/reduceQuantity")
	public ResponseEntity<ProductDto> reduceQuantity(@RequestBody ChangeProductQuantityRequest request) {
		return ResponseEntity.ok(productService.reduceQuantity(request));
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<Boolean> updateProduct(@RequestBody ProductDto productDto){
		return ResponseEntity.ok(productService.updateProduct(productDto));
	}
	@DeleteMapping("deleteProduct/{productId}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable Long productId){
		return ResponseEntity.ok(productService.deleteProduct(productId));
	}

	@GetMapping("getByCategory/{categoryId}")
	public ResponseEntity<List<ProductDto>> deleteProduct(@PathVariable Integer categoryId){
		return ResponseEntity.ok(productService.getProductByCategoryId(categoryId));
	}
	
}
