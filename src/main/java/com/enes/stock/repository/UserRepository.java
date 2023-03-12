package com.enes.stock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enes.stock.model.Product;
import com.enes.stock.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);
	
}
