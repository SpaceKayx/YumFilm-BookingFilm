package com.config.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "Country" )
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Country {
	@Id
	@Column(name = "CountryId", columnDefinition = "nvarchar(20)")
	String countryId;
	@Column(name = "CountryName" , columnDefinition = "nvarchar(100)", nullable = false)
	String countryName; 
	
	@Column(name = "Status" , nullable = false)
	boolean status;
	
	@OneToMany(mappedBy= "country")
	List<Film> listFilms;
}
