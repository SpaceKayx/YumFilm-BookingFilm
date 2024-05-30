package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.FilmType;

public interface FilmTypeRepository extends JpaRepository<FilmType, Integer> {

}
