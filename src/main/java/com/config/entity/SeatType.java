package com.config.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "SeatType" )
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatType {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "SeatTypeId")
	int seatTypeId;
	@Column(name = "SeatTypeName" , columnDefinition = "nvarchar(50)", nullable = false)
	String seatTypeName;
	
	@Column(name = "Price" , nullable = false)
	double price;
	@Column(name = "Status" , nullable = false)
	boolean status;
	
	@OneToMany(mappedBy = "seatType")
	List<SeatLocation> listSeatLocation;
	
	@OneToMany(mappedBy = "seatType")
	List<ShowTimeSeatType> listShowTimeSeatType;
}
