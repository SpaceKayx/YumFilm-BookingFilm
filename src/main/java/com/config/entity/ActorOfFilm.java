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
@Table(name = "ActorOfFilm" )
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActorOfFilm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ActorOfFilmId")
	int actorOfFilmId; 
	
	@ManyToOne
	@JoinColumn(name= "FilmDetailId" , nullable = false)
	FilmDetail filmDetail;
	
	@ManyToOne
	@JoinColumn(name= "ActorId" , nullable = false)
	Actor actor;
}
