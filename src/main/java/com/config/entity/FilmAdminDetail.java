package com.config.entity;

import java.util.Date;
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
	
	private String YearProduction;
	
	private String Description;
	
	private String FILMTYPES;
	
	private String FilmTime;
	
	private Date PremiereDate;
	
	private String DirectorName;
	
	private String ACTORS;
	
	private String CountryName;

}
