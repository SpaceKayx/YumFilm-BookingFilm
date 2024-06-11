package com.config.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.config.entity.OrderFood;

public interface OrderFoodRepository extends JpaRepository<OrderFood, Integer> {
	@Query(value = "SELECT f.foodName, f.description, f.price, SUM(of.price) FROM OrderFood of "
			+ " JOIN of.invoice i "	
			+ " JOIN of.food f "
			+ " WHERE f.status = true AND i.status = true"
			+ "	GROUP BY f.foodName, f.description, f.price"
			)
	Page<Object[]> getFoodTable(Pageable pageable);
}
