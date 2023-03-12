package com.enes.stock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CategoryIsAvailableException extends RuntimeException{
	public CategoryIsAvailableException(String message) {
		super(message);
	}

}
