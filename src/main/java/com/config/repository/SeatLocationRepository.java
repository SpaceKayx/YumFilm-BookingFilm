package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.SeatLocation;

public interface SeatLocationRepository extends JpaRepository<SeatLocation, Integer>{

}
