package com.enes.stock.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.enes.stock.exception.UserAlreadyAvailableException;
import com.enes.stock.exception.UserNotFoundException;
import com.enes.stock.model.User;
import com.enes.stock.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public User getOneUserByName(String name) {
		
		return Optional.of(userRepository.findByName(name))
				.orElseThrow(() -> new UserNotFoundException("user not found"));
	}
	
	public Boolean addUser(User newUser) {
		
		Optional<User> user = Optional.ofNullable( userRepository.findByName(newUser.getName()));
		
		if(user.isPresent()) throw new UserAlreadyAvailableException("User Already Available");
		
		userRepository.save(newUser);		
		return true;
		
	}
}
