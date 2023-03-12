package com.enes.stock.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enes.stock.dto.request.LoginRequest;
import com.enes.stock.dto.request.RegisterRequest;
import com.enes.stock.dto.response.AuthResponse;
import com.enes.stock.model.User;
import com.enes.stock.security.JwtTokenProvider;
import com.enes.stock.service.UserService;



@RestController
@RequestMapping("/v1/auth")
@CrossOrigin
public class AuthController {
	
	private AuthenticationManager authenticationManager;
	private JwtTokenProvider jwtTokenProvider;
	private UserService userService;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService, PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}
	@PostMapping("/login")
	public AuthResponse login(@RequestBody LoginRequest loginRequest) {
		System.out.println(loginRequest.getPassword());
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getName(), loginRequest.getPassword());
		Authentication  auth = authenticationManager.authenticate(authToken);
		System.out.println(auth.getCredentials());
		System.out.println(auth.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwtToken = jwtTokenProvider.generateJwtToken(auth);
		User user = userService.getOneUserByName(loginRequest.getName());
		AuthResponse authResponse = new AuthResponse();
		authResponse.setMessage("Bearer " +jwtToken);
		authResponse.setId(user.getId());
		authResponse.setName(user.getName());
		authResponse.setStatus(true);
		return authResponse;
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponse> resgister(@RequestBody RegisterRequest registerRequest){
		AuthResponse authResponse = new AuthResponse();
		if(userService.getOneUserByName(registerRequest.getName())!=null) {
			authResponse.setMessage("username already in use");
			return new ResponseEntity<>(authResponse,HttpStatus.BAD_REQUEST);  
		}
		User user = new User();
		user.setName(registerRequest.getName());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		userService.addUser(user);
		authResponse.setMessage("user successfully registered.");
		return new ResponseEntity<>(authResponse,HttpStatus.CREATED);
	}
	
}
