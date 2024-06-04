package com.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.config.entity.Film;
import com.config.entity.FilmAdminDetail;


@Repository
public interface AdminFimlRepository extends JpaRepository<Film, Integer> {
	
	@Query(value = """
		    WITH FilmGenresAggregated AS (
		        SELECT 
		            FILM.FilmId,
		            STRING_AGG(FT.FilmTypeName, ', ') WITHIN GROUP (ORDER BY FT.FilmTypeName) AS FILMTYPES
		        FROM 
		            FILM 
		            LEFT JOIN FilmGenres AS FG ON FILM.FilmId = FG.FilmId
		            LEFT JOIN FilmType AS FT ON FG.FilmTypeId = FT.FilmTypeId
		        GROUP BY 
		            FILM.FilmId
		    ),
		    FilmActorsAggregated AS (
		        SELECT 
		            FILM.FilmId,
		            STRING_AGG(ACTOR.ActorName, ', ') WITHIN GROUP (ORDER BY ACTOR.ActorName) AS ACTORS
		        FROM 
		            FILM 
		            LEFT JOIN FilmDetail ON FILM.FilmId = FilmDetail.FilmId
		            LEFT JOIN ActorOfFilm AS AOF ON FilmDetail.FilmDetailId = AOF.FilmDetailId
		            LEFT JOIN Actor AS ACTOR ON AOF.ActorId = ACTOR.ActorId
		        GROUP BY 
		            FILM.FilmId
		    )
		    SELECT 
		        FILM.FilmId,
		        FILM.FilmName,
		        FILM.FilmImage,
		        YEAR(FilmDetail.ProductionDate) AS YearProduction,
		        FGA.FILMTYPES,
		        FilmDetail.Description,
		        Film.FilmTime,
		        Film.PremiereDate,
		        Director.DirectorName,
		        FAA.ACTORS,
				Country.CountryName,
				Film.Rate
				
		    FROM 
		        FILM
		        LEFT JOIN FilmDetail ON FILM.FilmId = FilmDetail.FilmId
		        LEFT JOIN ProducerOfFilm ON ProducerOfFilm.FilmDetailId = FilmDetail.FilmDetailId
		        LEFT JOIN Producer ON Producer.ProducerId = ProducerOfFilm.ProducerId
		        LEFT JOIN FilmGenresAggregated AS FGA ON FILM.FilmId = FGA.FilmId
		        LEFT JOIN FilmActorsAggregated AS FAA ON FILM.FilmId = FAA.FilmId
		        LEFT JOIN DirectorOfFilm ON DirectorOfFilm.FilmDetailId = FilmDetail.FilmDetailId
		        LEFT JOIN Director ON Director.DirectorId = DirectorOfFilm.DirectorId
				LEFT JOIN Country ON Country.CountryId = Film.CountryId

		    WHERE FILM.FilmId = :filmId
		    GROUP BY 
		        FILM.FilmId,
		        FILM.FilmName,
		        FILM.FilmImage,
		        Film.PremiereDate,
		        FGA.FILMTYPES,
		        FilmDetail.Description,
		        Film.FilmTime,
		        Director.DirectorName,
		        FAA.ACTORS,
		        YEAR(FilmDetail.ProductionDate),
				Country.CountryName, 
				Film.Rate
				
		    """, nativeQuery = true)
	List<Object[]> detailFilmAdmin(@Param("filmId") Integer filmId);

	
	@Query(value = "SELECT FILM.FilmId,  FILM.FilmName, STRING_AGG( FilmTypeName , ', ') WITHIN GROUP (ORDER BY FILMTYPENAME) AS FILMTYPES, \r\n"
			+ "		FILM.AGE, FILM.FilmImage, FILM.RATE,FilmDetail.Description\r\n"
			+ "FROM FILM \r\n"
			+ "	LEFT JOIN FilmDetail ON FILM.FilmId= FilmDetail.FilmId\r\n"
			+ "	LEFT JOIN FilmGenres ON Film.FilmId = FilmGenres.FilmId\r\n"
			+ "	LEFT JOIN FilmType ON FilmType.FilmTypeId = FilmGenres.FilmTypeId\r\n"
			+ "GROUP BY FILM.FilmId, FILM.FILMNAME, FILM.AGE, FILM.RATE,FilmDetail.Description,FILM.FilmImage", nativeQuery = true)
	List<Object[]> listFilmAdmin();
	
}
