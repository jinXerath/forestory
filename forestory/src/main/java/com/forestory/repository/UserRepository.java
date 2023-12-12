package com.forestory.repository;

import org.springframework.data.repository.CrudRepository;

import com.forestory.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	boolean existsByUserEmail(String userEmail);
	boolean existsByUserNick(String userNick);
	
}
