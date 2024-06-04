package com.config.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.config.entity.Actor;
import com.config.entity.ActorOfFilm;
import com.config.entity.Country;
import com.config.entity.Director;
import com.config.entity.DirectorOfFilm;
import com.config.entity.Film;
import com.config.entity.FilmAdminDetail;
import com.config.entity.FilmDetail;
import com.config.entity.FilmGenres;
import com.config.entity.FilmType;
import com.config.repository.AdminFimlRepository;

import lombok.AllArgsConstructor;

@Service
public class AdminFimlService {
	
	@Autowired
	private AdminFimlRepository repo;
	
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
	
	public  void addFilm(@RequestParam("filmName") String filmName, @RequestParam("produtionDate") Date produtionDate, @RequestParam("filmTime") String filmTime,
			@RequestParam("director") String directorName) {
		Film film = new Film();
		FilmDetail film_detail = new FilmDetail();
		FilmGenres film_genres = new FilmGenres();
		FilmType film_type = new FilmType();
		Actor actors = new Actor();
		ActorOfFilm actorOfFim = new ActorOfFilm();
		Country country = new Country();
		Director director = new Director();
		DirectorOfFilm directorOfFilm = new DirectorOfFilm();
		
		film.setFilmName(filmName);
//		film_detail(produtionDate);
		film.setFilmTime(filmTime);
		director.setDirectorName(directorName);
		film.getListFilmGenres().add(film_genres);
		
	}

	
}
