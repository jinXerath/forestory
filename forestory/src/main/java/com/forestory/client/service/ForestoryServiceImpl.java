package com.forestory.client.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forestory.domain.Board;
import com.forestory.domain.Forestory;
import com.forestory.repository.ForestoryRepository;

import lombok.Setter;

@Service
public class ForestoryServiceImpl implements ForestoryService {
	
	@Setter(onMethod_ = @Autowired)
	private ForestoryRepository forestoryRepository;

	@Override
	public List<Forestory> forestoryList(Forestory forestory) {
		List<Forestory> forestoryList = (List<Forestory>)forestoryRepository.findAll();
		
		return forestoryList;
	}
	
	@Override
	@Transactional
	public Forestory save(Forestory forestory) {
		Forestory result = forestoryRepository.save(forestory);
		
		return result;
	}
	
}
