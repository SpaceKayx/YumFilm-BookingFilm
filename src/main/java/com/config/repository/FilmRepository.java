package com.config.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.config.entity.Film;

import jakarta.persistence.NamedQuery;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
	
	@Query(value = "SELECT TOP(:quantity) f.FilmName, f.FilmImage, STRING_AGG(ft.FilmTypeName, ', ') WITHIN GROUP (ORDER BY ft.FilmTypeName) AS FILMTYPES, f.Rate "
			+ "FROM Film f \r\n"
			+ "	JOIN \r\n" + "		FilmGenres fg ON f.FilmId = fg.FilmId\r\n" + "	JOIN \r\n"
			+ "		FilmType ft ON fg.FilmTypeId = ft.FilmTypeId\r\n"
			+ "	WHERE MONTH(f.PremiereDate) = MONTH(GETDATE()) and YEAR(f.PremiereDate) = YEAR(GETDATE()) \r\n"
			+ "	GROUP BY f.FilmName, f.Rate, f.FilmImage\r\n" + "	ORDER BY NEWID()", nativeQuery = true)
	List<Object[]> findFilmsHotInMonth(@Param("quantity") int quantity);

	default List<Object[]> findFilmsHotInMonth() {
		return findFilmsHotInMonth(4);
	}
	
	@Query(value = "select f.FilmName, f.FilmImage, STRING_AGG(ft.FilmTypeName, ', ') WITHIN GROUP (ORDER BY ft.FilmTypeName) AS FILMTYPES, f.Rate\r\n"
			+ "from Film f \r\n"
			+ "join FilmGenres fg on f.FilmId = fg.FilmId \r\n"
			+ "join FilmType ft on fg.FilmTypeId = ft.FilmTypeId\r\n"
			+ "where Month(f.PremiereDate) > month(getDate()) and year(f.PremiereDate) >= year(getDate())\r\n"
			+ "GROUP BY f.FilmName, f.Rate, f.FilmImage", nativeQuery = true)
	List<Object[]> findupcomingMovie();

	
	@Query(value = "SELECT f FROM Film f WHERE f.status = True")
	Page<Film> getFilmTable(Pageable pageable);

	@Query(value = "SELECT f FROM Film f WHERE f.status = True")
	List<Film> getFilmStatusTrue();
}
