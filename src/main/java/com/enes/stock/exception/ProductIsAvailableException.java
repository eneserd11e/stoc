package com.enes.stock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProductIsAvailableException extends RuntimeException{
	
	public ProductIsAvailableException(String message) {
		super(message);
	}
}
