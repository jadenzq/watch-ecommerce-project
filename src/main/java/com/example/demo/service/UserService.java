package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
	
	boolean save(User user);
	
	User findByUsername(String username);
}
