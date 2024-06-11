package com.config.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.config.entity.FilmGenres;

public interface FilmGenresRepository extends JpaRepository<FilmGenres, Integer>{
	@Query("SELECT fg FROM FilmGenres fg "
	    		+ "WHERE fg.filmType.filmTypeId = :filmTypeId "
	    		+ "AND fg.film.filmId = :filmId")
	Optional<FilmGenres> findByFilmTypeAndFilm(int filmTypeId, int filmId);
}
