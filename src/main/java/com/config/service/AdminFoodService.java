package com.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.entity.Food;
import com.config.repository.FoodRepository;

@Service
public class AdminFoodService {

	@Autowired
	FoodRepository repo;
	
	public List<Food> findAll(){
		return repo.findAll();
	}
}
