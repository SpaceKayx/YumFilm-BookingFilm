package com.config.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.config.entity.ActorOfFilm;

public interface ActorOfFilmRepository extends JpaRepository<ActorOfFilm, Integer> {
    @Query("SELECT aof FROM ActorOfFilm aof "
    		+ "WHERE aof.filmDetail.filmDetailId = :filmDetailId "
    		+ "AND aof.actor.actorId = :actorId ")
	Optional<ActorOfFilm> findByActorAndFilmDetail( int filmDetailId,int actorId);
    
    @Query("SELECT aof FROM ActorOfFilm aof "
    		+ "WHERE aof.filmDetail.filmDetailId = :filmDetailId "
    		)
    Optional<ActorOfFilm> findByFilmDetail( int filmDetailId);
}
