package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.Film;

public interface FilmRepository  extends JpaRepository<Film, Integer>{

}
