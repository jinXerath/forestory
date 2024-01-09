package com.forestory.client.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forestory.client.service.ForestoryService;
import com.forestory.domain.Forestory;
import com.forestory.dto.ForestoryDTO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/forestory/*")
public class forestoryController {

	@Setter(onMethod_= @Autowired)
	private ForestoryService forestoryService;
	
	@GetMapping("/insertForm")
	public String forestoryInsertForm() {
		log.info("forestoryInsertForm 메소드 호출성공");
		
		return "client/forestory/forestoryInsertForm";
	}
	
	//forestory 상세보기 구현
	
//	@GetMapping("/detail")
//	public String forestoryDetail(@ModelAttribute ForestoryDTO forestoryDTO, Model model) {
//		log.info("forestoryDetail 메소드 호출성공");
//		ForestoryDTO deatail = forestoryRepository.findByForestoryNo(forestoryDTO.getForestoryNo());
//	}
	
	@GetMapping("/list")
	public String forestory(Model model) {
		log.info("forestoryList 메소드 호출성공");
		
		List<Forestory> forestoryList = forestoryService.forestoryList();
		model.addAttribute("forestoryList", forestoryList);
		return "client/forestory/forestoryList";
	}
	
	@PostMapping("/insert")
	public String forestoryInsert(@Valid ForestoryDTO forestoryDTO, BindingResult bindingResult, Model model) {
		log.info("forestoryInsert 메소드 호출 성공");
		if(bindingResult.hasErrors()) {
			model.addAttribute("forestoryDTO", forestoryDTO);
			
//			System.out.println(bindingResult.)
		}
		
		Forestory forestory = Forestory.builder(forestoryDTO).build();
		
		forestory = forestoryService.save(forestory);
		
		if(forestory != null) {
			System.out.println("insert 성공");
		} else {
			System.out.println("insert 실패");			
		}
		
		return "redirect:/forestory/list";
	}
	
}
