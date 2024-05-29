package com.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.entity.Food;
import com.config.repository.FoodRepository;

@Service
public class FoodService {

	@Autowired
	FoodRepository foodRepository;

	public List<Food> findAll() {
		return foodRepository.findAll();
	}
	
	
}
