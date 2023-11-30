package com.forestory.admin.service;

import java.util.Map;

import org.springframework.validation.Errors;

import com.forestory.domain.User;

public interface UserService {
	public User signUp(User user);
	public boolean existsByUserEmail(String userEmail);
	public boolean existsByUserNick(String userNick);
	public Map<String, String> validateHandling(Errors errors);
}
