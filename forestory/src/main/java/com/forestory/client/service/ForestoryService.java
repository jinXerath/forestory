package com.forestory.client.service;

import java.util.List;

import com.forestory.domain.Forestory;

public interface ForestoryService {
	public List<Forestory> forestoryList(Forestory forestory);
	public Forestory save(Forestory forestory);
}
