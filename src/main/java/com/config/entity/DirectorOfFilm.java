package com.config.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DirectorOfFilm" )
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DirectorOfFilm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DirectorOfFilmId")
	int directorOfFilmId; 
	
	@ManyToOne
	@JoinColumn(name= "FilmId" , nullable = false)
	FilmDetail filmDetail;
	
	@ManyToOne
	@JoinColumn(name= "DirectorId" , nullable = false)
	Director director;
}