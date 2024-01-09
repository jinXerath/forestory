package com.forestory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.forestory.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	Page<Board> findByBoardCategory(String boardCategory, Pageable pageable);
	Page<Board> findByBoardTitleContaining(String keyword, Pageable pageable);
	Page<Board> findByBoardTitleContainingOrBoardContentContaining(String title, String content, Pageable pageable);
}
