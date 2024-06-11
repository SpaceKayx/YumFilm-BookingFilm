package com.config.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
	Optional<Actor> findByActorName(String name);
}
