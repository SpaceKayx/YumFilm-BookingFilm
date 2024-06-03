package com.config.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.entity.Film;
import com.config.entity.FilmAdminDetail;
import com.config.repository.AdminFimlRepository;

import lombok.AllArgsConstructor;

@Service
public class AdminFimlService {
	
	@Autowired
	private AdminFimlRepository repo;
	
//	
//	
//	public List<Film> finAll(){
//		return repo.findAll();
//	}
	
	
	
	public List<Object[]> findAll(){
//		System.out.println(listFilmAdmin());
		return repo.listFilmAdmin();
		
	}
	
	public Film findById(Integer id) {
		return repo.findById(id).get();
	}

	public FilmAdminDetail detailFimlAdmin(int filmId){
		List<Object[]> objs = repo.detailFilmAdmin(filmId);
		Object[] obj = objs.get(0);
		FilmAdminDetail filmAdminDetail = FilmAdminDetail.builder()
				.FilmId(Integer.parseInt(obj[0].toString()))
				.FilmName(obj[1].toString())
				.FilmImage(obj[2].toString())
				.YearProduction(obj[3].toString())
				.FILMTYPES(obj[4].toString())
				.Description(obj[5].toString())
				.FilmTime(obj[6].toString())
				.PremiereDate((Date)obj[7])
				.DirectorName(obj[8].toString())
				.ACTORS(obj[9].toString())
				.CountryName(obj[10].toString())
				.build();
		return filmAdminDetail;
	}
	
}
