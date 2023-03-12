package com.enes.stock.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.enes.stock.model.User;
import com.enes.stock.repository.UserRepository;
import com.enes.stock.security.JwtUserDetails;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UserRepository userRepository;
	
	//constructor injection
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username);
		
		return JwtUserDetails.create(user);
	}
	
	public UserDetails loadUserById(Long id) {
		com.enes.stock.model.User user = this.userRepository.findById(id).get();
		return JwtUserDetails.create(user);
	}
}
