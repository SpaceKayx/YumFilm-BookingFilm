package com.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.entity.SeatLocation;
import com.config.repository.SeatLocationRepository;

@Service
public class SeatLocationService {

	@Autowired
	SeatLocationRepository seatLocationRepository;

	public List<SeatLocation> findAll() {
		return seatLocationRepository.findAll();
	}
	
	public SeatLocation findBySeatNumber(String name) {
		return seatLocationRepository.findBySeatNumber(name);
	}
}
