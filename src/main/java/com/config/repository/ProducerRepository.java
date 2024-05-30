package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.Producer;

public interface ProducerRepository  extends JpaRepository<Producer, Integer>{

}
