package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.config.entity.SeatLocation;

@Repository
public interface SeatLocationRepository extends JpaRepository<SeatLocation, Integer>{
	
	
}
