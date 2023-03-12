package com.enes.stock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ProductQuantityCannnotBeNegativeException extends RuntimeException {
	
	public ProductQuantityCannnotBeNegativeException(String message) {
		super(message);
	}
}
