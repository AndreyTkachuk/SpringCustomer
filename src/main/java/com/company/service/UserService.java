package com.company.service;


import com.company.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}