package com.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.entity.Film;
import com.config.repository.FilmRepository;

@Service
public class FilmService {
	
	@Autowired
	FilmRepository filmRepository;

	public List<Film> findAll() {
		return filmRepository.findAll();
	}
	
	
}
