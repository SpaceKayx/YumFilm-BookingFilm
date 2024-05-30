package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.OrderFood;

public interface OrderFoodRepository extends JpaRepository<OrderFood, Integer> {

}
