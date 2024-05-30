package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.entity.CinemaRoom;

public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Integer> {

}
