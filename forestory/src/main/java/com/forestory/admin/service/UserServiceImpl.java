package com.forestory.admin.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.forestory.domain.User;
import com.forestory.repository.UserRepository;

import lombok.Setter;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	@Setter(onMethod_=@Autowired)
	private UserRepository userRepository;
	
	public User signUp(User user) {
		return userRepository.save(user);
	}
	
	public boolean existsByUserEmail(String userEmail) {
		return userRepository.existsByUserEmail(userEmail);
	}
	
	@Override
	public boolean existsByUserNick(String userNick) {
		return userRepository.existsByUserNick(userNick);
	}

	@Override
	public Map<String, String> validateHandling(Errors errors) {
		Map<String, String> validatorResult = new HashMap<>();
		
		for (FieldError error : errors.getFieldErrors()) {
			String validKeyName = String.format("valid_%s", error.getField());
			validatorResult.put(validKeyName, error.getDefaultMessage());
		}
		return validatorResult;
	}


}
