package com.forestory.client.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.forestory.domain.Board;
import com.forestory.dto.BoardDTO;

public interface BoardService {
	
	public Page<Board> boardList(String boardCategory, String keyword, Pageable pageable);
	public BoardDTO boardDetail(long boardNo);
	public Board save(BoardDTO boardDTO);
	public Board update(long boardNo, BoardDTO boardDTO);
}
