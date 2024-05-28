package com.config.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "FilmDetail" )
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FilmDetailId")
	int filmDetailId;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "ProductionDate" , columnDefinition = "date" , nullable = false)
	Date produtionDate;
	
	@Column(name = "Description" , columnDefinition = "nvarchar(max)", nullable = false)
	String description;
	@Column(name = "Status" , nullable = false)
	boolean status; 
	
	@ManyToOne
	@JoinColumn(name = "FilmId" , nullable =false)
	Film film;
	
	@OneToMany(mappedBy = "filmDetail")
	List<ActorOfFilm> listActorOfFilm;
	
	@OneToMany(mappedBy = "filmDetail")
	List<ProducerOfFilm> listProducerOfFilm;
	
	@OneToMany(mappedBy = "filmDetail")
	List<DirectorOfFilm> listDirectorOfFilm;
	
}
