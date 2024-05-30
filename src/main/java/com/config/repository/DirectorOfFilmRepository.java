package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.DirectorOfFilm;

public interface DirectorOfFilmRepository extends JpaRepository<DirectorOfFilm, Integer> {

}
