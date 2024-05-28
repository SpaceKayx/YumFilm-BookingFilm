package com.config.entity;

import java.util.List;

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
@Table(name = "ShowTimeSeatType" )
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShowTimeSeatType {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "ShowTimeSeatTypeId")
	long showTimeSeatTypeId;
	@Column(name = "Price" , nullable = false)
	double price;
	
	@ManyToOne
	@JoinColumn(name = "SeatTypeId")
	SeatType seatType;
	
	@ManyToOne
	@JoinColumn(name = "ShowTimeId")
	ShowTime showTime;
}
