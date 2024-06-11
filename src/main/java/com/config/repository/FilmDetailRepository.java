package com.config.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.config.entity.FilmDetail;

public interface FilmDetailRepository  extends JpaRepository<FilmDetail, Integer>{
    @Query("SELECT fd FROM FilmDetail fd WHERE fd.film.id = :filmId")
	Optional<FilmDetail> findByFilmId(int filmId);
}
