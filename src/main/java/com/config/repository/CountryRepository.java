package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

}
