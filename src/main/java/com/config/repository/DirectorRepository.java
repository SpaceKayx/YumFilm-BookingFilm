package com.config.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.Director;

public interface DirectorRepository  extends JpaRepository<Director, Integer>{

	Optional<Director> findByDirectorName(String name);
}
