package com.forestory.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forestory.client.service.BoardService;
import com.forestory.domain.Board;

import lombok.Setter;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		List<Board> boardList = boardService.boardList();
		
		model.addAttribute("boardList", boardList);
		
		return "client/board/boardList";
	}
	
	@GetMapping("/boardInsertForm")
	public String boardInsertForm() {
		return "client/board/boardInsertForm";
	}
	
	@PostMapping("/boardInsert")
	public String boardInsert(@ModelAttribute Board board) {
		
		Board result = boardService.boardInsert(board);
		
		if(result != null) {
			System.out.println("insert 성공");
		} else {
			System.out.println("insert 실패");			
		}
		
		return "redirect:/board/boardList";
	}
	
}
