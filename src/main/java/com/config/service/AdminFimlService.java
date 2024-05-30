package com.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.entity.Film;
import com.config.repository.AdminFimlRepository;

@Service
public class AdminFimlService {
	
	@Autowired
	AdminFimlRepository repo;
	
	public List<Film> finAll(){
		return repo.findAll();
	}
}
