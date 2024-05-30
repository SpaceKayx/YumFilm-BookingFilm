package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {

}
