package com.config.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.config.entity.DirectorOfFilm;

public interface DirectorOfFilmRepository extends JpaRepository<DirectorOfFilm, Integer> {
	 @Query("SELECT dof FROM DirectorOfFilm dof "
	    		+ "WHERE dof.filmDetail.filmDetailId = :filmDetailId "
	    		+ "AND dof.director.directorId = :directorId ")
	Optional<DirectorOfFilm> findByFilmDetailAndDirector( int filmDetailId,int directorId);
	
	 @Query("SELECT dof FROM DirectorOfFilm dof "
	    		+ "WHERE dof.filmDetail.filmDetailId = :filmDetailId "
	    		)
	Optional<DirectorOfFilm> findByFilmDetail( int filmDetailId);
}
