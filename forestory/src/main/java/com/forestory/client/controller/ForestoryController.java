package com.forestory.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forestory.repository.ForestoryRepository;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/forestory")
public class ForestoryController {
	
	@Setter(onMethod_ = @Autowired)
	private ForestoryRepository forestoryRepository;
	
	@GetMapping("/list")
	public String forestoryList() {
		log.info("forestoryList 메소드호출"); 
		return "client/forestory/forestoryList";
	}
	
	@GetMapping("insertForm")
	public String forestoryInsertForm() {
		log.info("forestoryInsertForm 메소드호출");
		return "client/forestory/forestoryInsertForm";
	}
}
