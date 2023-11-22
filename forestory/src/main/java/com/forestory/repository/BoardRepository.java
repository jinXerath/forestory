package com.forestory.repository;

import org.springframework.data.repository.CrudRepository;

import com.forestory.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

	
}
