package com.forestory.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.forestory.domain.Board;

@SpringBootTest
public class BoardRepositoryTests {

	@Autowired
	BoardRepository boardRepository;
	
	@Test
	public void findByBoardTitleContainingTest() {
		Page<Board> list = boardRepository.findByBoardTitleContainingOrBoardContentContaining("오", "오", null);
		
		for(Board board : list) {
			System.out.println(board.toString());
		}
	}
}
