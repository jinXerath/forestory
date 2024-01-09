package com.forestory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forestory.domain.Forestory;

public interface ForestoryRepository extends JpaRepository<Forestory, Long>{
	public List<Forestory> findByForestoryNo(Long forestroyNo);
}
