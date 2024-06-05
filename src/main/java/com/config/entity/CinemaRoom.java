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
@Table(name = "CinemaRoom" )
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CinemaRoom {
	
	@Id
	@Column(name = "CinemaRoomId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cinemaRoomId;
	
	@Column(name = "NameRoom", columnDefinition = "nvarchar(50)", nullable = false)
	String nameRoom;
	
	@Column(name = "Status", nullable = false)
	boolean status;
	
	@ManyToOne
	@JoinColumn(name = "ShowTimeId")
	ShowTime showTime;
	
	@ManyToOne
	@JoinColumn(name = "SeatLocationId")
	SeatLocation seatLocation;
}
