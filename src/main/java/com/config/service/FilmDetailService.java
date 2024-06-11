package com.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.repository.FilmDetailRepository;

@Service

public class FilmDetailService {
	@Autowired
	FilmDetailRepository filmDetailRepository;
	
	public List<Object[]> findAllFilms(){
		return filmDetailRepository.findFilmsAll();	
	}
	
	public Object[] findFilmDetailById(int id){
		return filmDetailRepository.findFilmDetailById(id);
	}
}
