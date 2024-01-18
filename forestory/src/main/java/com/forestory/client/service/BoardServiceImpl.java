package com.forestory.client.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.forestory.domain.Board;
import com.forestory.dto.BoardDTO;
import com.forestory.repository.BoardRepository;

import lombok.Setter;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_ = @Autowired)
	private BoardRepository boardRepository;

	@Override
	public Page<Board> boardList(String boardCategory, String keyword, Pageable pageable) {
		Page<Board> boardList = null;
		
		if(boardCategory == null && keyword == null) {
			boardList = boardRepository.findAll(pageable);
		} else if (boardCategory != null && keyword == null){
			boardList = boardRepository.findByBoardCategory(boardCategory, pageable);
		} else if (boardCategory == null && keyword != null) {
			boardList = boardRepository.findByBoardTitleContainingOrBoardContentContaining(keyword, keyword, pageable);
		} else {
			boardList = boardRepository.findByCategoryAndTitleOrContentWithPaging(boardCategory, keyword, keyword, pageable);
		}
		
		return boardList;
	}
	
	@Override
	@Transactional
	public Board save(BoardDTO boardDTO) {
		Board board = Board.toEntity(boardDTO);
		Board result = boardRepository.save(board);
		
		return result;
	}

	@Override
	@Transactional
	public BoardDTO boardDetail(long boardNo) {
		Board entity = boardRepository.findById(boardNo).orElseThrow(() -> new IllegalArgumentException("해당 글번호가 존재하지 않습니다."));
		
		entity.plusHit();
		
		BoardDTO boardDto = BoardDTO.toDto(entity);
		
		return boardDto;
	}

	@Override
	@Transactional
	public Board update(long boardNo, BoardDTO boardDTO) {
		Board findBoard = boardRepository.findById(boardNo).orElseThrow(() -> new IllegalArgumentException("해당 글번호가 존재하지 않습니다."));
		
		findBoard.setBoardCategory(boardDTO.getBoardCategory());
		findBoard.setBoardTitle(boardDTO.getBoardTitle());
		findBoard.setBoardContent(boardDTO.getBoardContent());
		
		return findBoard;
	}

	


}
