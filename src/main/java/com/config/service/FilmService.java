package com.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.entity.Country;
import com.config.entity.Film;
import com.config.repository.FilmRepository;

@Service
public class FilmService {
	@Autowired
	FilmRepository filmRepository;

	public List<Film> getAll() {
		return filmRepository.findAll();
	}

//	public Country findByCountryName(String countryName) {
//		Country country = new Country();
//		for (Film film : filmRepository.findAll()) {
//			country = filmRepository.findById(film.getFilmId()).get().getCountry();
//		}
//		return country;
//	}
}
