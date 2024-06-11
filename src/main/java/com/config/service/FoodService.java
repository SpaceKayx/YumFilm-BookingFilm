package com.config.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.entity.Food;
import com.config.repository.FoodRepository;
@Service
public class FoodService{

	@Autowired
	FoodRepository foodRepository;
	
	public List<Food> selectAll()
	{
		return foodRepository.findAll();
	}
	

	public void deleteById(int id) {
		foodRepository.deleteById(id);
	}

	public <S extends Food> S save(S entity) {
		return foodRepository.save(entity);
	}


	public Food findById(Integer id) {
		return foodRepository.findById(id).get();
	}
	
	
	
}
