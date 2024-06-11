package com.config.repository;


import java.util.Optional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.config.entity.FilmDetail;


@Repository
public interface FilmDetailRepository extends JpaRepository<FilmDetail, Integer>{
	@Query("SELECT fd FROM FilmDetail fd WHERE fd.film.id = :filmId")
	Optional<FilmDetail> findByFilmId(int filmId);
	
	@Query(value = "WITH FilmGenresAggregated AS (\r\n"
			+ "    SELECT \r\n"
			+ "        FILM.FilmId,\r\n"
			+ "        STRING_AGG(FT.FilmTypeName, ', ') WITHIN GROUP (ORDER BY FT.FilmTypeName) AS FILMTYPES\r\n"
			+ "    FROM \r\n"
			+ "        FILM \r\n"
			+ "        LEFT JOIN FilmGenres AS FG ON FILM.FilmId = FG.FilmId\r\n"
			+ "        LEFT JOIN FilmType AS FT ON FG.FilmTypeId = FT.FilmTypeId\r\n"
			+ "    GROUP BY \r\n"
			+ "        FILM.FilmId\r\n"
			+ "),\r\n"
			+ "FilmActorsAggregated AS (\r\n"
			+ "    SELECT \r\n"
			+ "        FILM.FilmId,\r\n"
			+ "        STRING_AGG(ACTOR.ActorName, ', ') WITHIN GROUP (ORDER BY ACTOR.ActorName) AS ACTORS\r\n"
			+ "    FROM \r\n"
			+ "        FILM \r\n"
			+ "        LEFT JOIN FilmDetail ON FILM.FilmId = FilmDetail.FilmId\r\n"
			+ "        LEFT JOIN ActorOfFilm AS AOF ON FilmDetail.FilmDetailId = AOF.FilmDetailId\r\n"
			+ "        LEFT JOIN Actor AS ACTOR ON AOF.ActorId = ACTOR.ActorId\r\n"
			+ "    GROUP BY \r\n"
			+ "        FILM.FilmId\r\n"
			+ ")\r\n"
			+ "SELECT  \r\n"
			+ "    FILM.FilmId,\r\n"
			+ "    FILM.FilmName,\r\n"
			+ "    FILM.FilmImage,\r\n"
			+ "    FGA.FILMTYPES,\r\n"
			+ "    FILM.AGE,\r\n"
			+ "    FILM.RATE,\r\n"
			+ "    FilmDetail.Description,\r\n"
			+ "    Film.FilmTime,\r\n"
			+ "    YEAR(FilmDetail.ProductionDate) AS ProductionYear,\r\n"
			+ "    Producer.ProducerName,\r\n"
			+ "    FAA.ACTORS\r\n"
			+ "FROM \r\n"
			+ "    FILM \r\n"
			+ "    LEFT JOIN FilmDetail ON FILM.FilmId = FilmDetail.FilmId\r\n"
			+ "    LEFT JOIN ProducerOfFilm ON ProducerOfFilm.FilmDetailId = FilmDetail.FilmDetailId\r\n"
			+ "    LEFT JOIN PRODUCER ON Producer.ProducerId = ProducerOfFilm.ProducerId\r\n"
			+ "    LEFT JOIN FilmGenresAggregated AS FGA ON FILM.FilmId = FGA.FilmId\r\n"
			+ "    LEFT JOIN FilmActorsAggregated AS FAA ON FILM.FilmId = FAA.FilmId\r\n"
			+ "    where FILM.PremiereDate < GETDATE()\r\n"
			+ "GROUP BY \r\n"
			+ "    FILM.FilmId,\r\n"
			+ "    FILM.FilmName,\r\n"
			+ "    FILM.FilmImage,\r\n"
			+ "    FGA.FILMTYPES,\r\n"
			+ "    FILM.AGE,\r\n"
			+ "    FILM.RATE, \r\n"
			+ "    FilmDetail.Description,\r\n"
			+ "    Film.FilmTime,\r\n"
			+ "    YEAR(FilmDetail.ProductionDate),\r\n"
			+ "    Producer.ProducerName,\r\n"
			+ "    FAA.ACTORS;", nativeQuery = true)
		List<Object[]> findFilmsAll();
		
		
		@Query (value = "WITH FilmGenresAggregated AS (\r\n"
				+ "    SELECT \r\n"
				+ "        FILM.FilmId,\r\n"
				+ "        STRING_AGG(FT.FilmTypeName, ', ') WITHIN GROUP (ORDER BY FT.FilmTypeName) AS FILMTYPES\r\n"
				+ "    FROM \r\n"
				+ "        FILM \r\n"
				+ "        LEFT JOIN FilmGenres AS FG ON FILM.FilmId = FG.FilmId\r\n"
				+ "        LEFT JOIN FilmType AS FT ON FG.FilmTypeId = FT.FilmTypeId\r\n"
				+ "    GROUP BY \r\n"
				+ "        FILM.FilmId\r\n"
				+ "),\r\n"
				+ "FilmActorsAggregated AS (\r\n"
				+ "    SELECT \r\n"
				+ "        FILM.FilmId,\r\n"
				+ "        STRING_AGG(ACTOR.ActorName, ', ') WITHIN GROUP (ORDER BY ACTOR.ActorName) AS ACTORS\r\n"
				+ "    FROM \r\n"
				+ "        FILM \r\n"
				+ "        LEFT JOIN FilmDetail ON FILM.FilmId = FilmDetail.FilmId\r\n"
				+ "        LEFT JOIN ActorOfFilm AS AOF ON FilmDetail.FilmDetailId = AOF.FilmDetailId\r\n"
				+ "        LEFT JOIN Actor AS ACTOR ON AOF.ActorId = ACTOR.ActorId\r\n"
				+ "    GROUP BY \r\n"
				+ "        FILM.FilmId\r\n"
				+ ")\r\n"
				+ "SELECT  \r\n"
				+ "    FILM.FilmId,\r\n"
				+ "    FILM.FilmName,\r\n"
				+ "    FILM.FilmImage,\r\n"
				+ "	Country.CountryName,\r\n"
				+ "    FGA.FILMTYPES,\r\n"
				+ "	FILM.AGE,\r\n"
				+ "    FILM.RATE,\r\n"
				+ "    FilmDetail.Description,\r\n"
				+ "    Film.FilmTime,\r\n"
				+ "    YEAR(FilmDetail.ProductionDate) AS ProductionYear,\r\n"
				+ "    Director.DirectorName,\r\n"
				+ "    FAA.ACTORS\r\n"
				+ "FROM \r\n"
				+ "    FILM \r\n"
				+ "    LEFT JOIN FilmDetail ON FILM.FilmId = FilmDetail.FilmId\r\n"
				+ "	LEFT JOIN Country ON Country.CountryId = Film.CountryId\r\n"
				+ "    LEFT JOIN ProducerOfFilm ON ProducerOfFilm.FilmDetailId = FilmDetail.FilmDetailId\r\n"
				+ "    LEFT JOIN PRODUCER ON Producer.ProducerId = ProducerOfFilm.ProducerId\r\n"
				+ "    LEFT JOIN FilmGenresAggregated AS FGA ON FILM.FilmId = FGA.FilmId\r\n"
				+ "    LEFT JOIN FilmActorsAggregated AS FAA ON FILM.FilmId = FAA.FilmId\r\n"
				+ "	LEFT JOIN DirectorOfFilm on DirectorOfFilm.FilmDetailId =FilmDetail.FilmDetailId\r\n"
				+ "	LEFT JOIN Director on Director.DirectorId = DirectorOfFilm.DirectorId\r\n"
				+ "WHERE Film.FilmId = (:id)\r\n"
				+ "GROUP BY \r\n"
				+ "    FILM.FilmId,\r\n"
				+ "    FILM.FilmName,\r\n"
				+ "    FILM.FilmImage,\r\n"
				+ "	Country.CountryName,\r\n"
				+ "    FGA.FILMTYPES,\r\n"
				+ "	FILM.AGE,\r\n"
				+ "    FILM.RATE,\r\n"
				+ "    FilmDetail.Description,\r\n"
				+ "    Film.FilmTime,\r\n"
				+ "    YEAR(FilmDetail.ProductionDate),\r\n"
				+ "    Director.DirectorName,\r\n"
				+ "    FAA.ACTORS;", nativeQuery = true)
		Object[] findFilmDetailById(@Param("id") int id);
}

