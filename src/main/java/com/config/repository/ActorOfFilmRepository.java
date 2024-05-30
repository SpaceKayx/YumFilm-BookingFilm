package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.ActorOfFilm;

public interface ActorOfFilmRepository extends JpaRepository<ActorOfFilm, Integer> {

}
