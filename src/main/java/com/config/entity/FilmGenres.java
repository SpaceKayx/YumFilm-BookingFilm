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
@Table(name = "FilmGenres" )
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmGenres {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FilmGenresId")
	int filmGenresId;
	
	@ManyToOne
	@JoinColumn(name = "FilmId")
	Film film;
	
	@ManyToOne
	@JoinColumn(name = "FilmTypeId")
	FilmType filmType;
}
