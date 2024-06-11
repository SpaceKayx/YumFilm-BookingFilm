package com.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.entity.Country;
import com.config.repository.CountryRepository;

@Service
public class CountryService {
	@Autowired
	CountryRepository countryRepository;
	
	public Country findById(String countryId) {
		return countryRepository.findById(countryId).get();
	} 
}
