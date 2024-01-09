package com.forestory.client.service;

import java.util.List;

import com.forestory.domain.Forestory;
import com.forestory.dto.ForestoryDTO;

public interface ForestoryService {
	public List<Forestory> forestoryList();
	public Forestory save(Forestory forestory);
}
