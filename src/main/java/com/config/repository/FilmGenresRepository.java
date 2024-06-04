package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.FilmGenres;

public interface FilmGenresRepository extends JpaRepository<FilmGenres, Integer>{

}
