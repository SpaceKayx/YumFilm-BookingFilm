package com.config.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmAdminDetail {

	private int FilmId;
	
	private String FilmName;
	
	private String FilmImage;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date YearProduction;
	
	private String Description;
	
	private String FILMTYPES;
	
	private String FilmTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date PremiereDate;
	
	private String DirectorName;
	
	private String ACTORS;
	
	private String CountryName;
	
	private String CountryId;
	
	private Double price;
	
	private int age;

}
