package com.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.config.entity.ShowTime;

@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTime, Integer>{
	
	
	@Query(value = "select * from ShowTime st join ShowTimeList stl on st.ShowTimeListId = stl.ShowTimeListId where filmid = (:idFilm) and ShowTimeDate = '2024-05-20'" , nativeQuery = true)
	List<Object[]> findFilmShowTime(@Param("idFilm") int idFilm);
	
	
}
