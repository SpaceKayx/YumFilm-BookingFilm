package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.config.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>{

}
