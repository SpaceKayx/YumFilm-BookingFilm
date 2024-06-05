package com.config.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.entity.ShowTime;
import com.config.repository.ShowTimeRepository;

@Service
public class ShowTimeService {
	
	@Autowired
	ShowTimeRepository showTimeRepository;
	
	public List<Object[]> getFilmShowTime(int id){
		return showTimeRepository.findFilmShowTime(id);
	}

	public ShowTime findById(Integer id) {
		return showTimeRepository.findById(id).get();
	}
	
	
}
