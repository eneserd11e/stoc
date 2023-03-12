package com.enes.stock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyAvailableException extends RuntimeException{
	
	public UserAlreadyAvailableException(String message) {
		super(message);
	}

}
