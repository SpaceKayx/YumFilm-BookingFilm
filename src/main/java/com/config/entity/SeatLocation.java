package com.config.entity;

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
@Table(name = "SeatLocation" )
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SeatLocationId")
	int seatLocationId;
	@Column(name = "SeatNumber" , columnDefinition = "nvarchar(20)" , nullable = false)
	String seatNumber;
	@Column(name= "Status", nullable = false)
	boolean status;
	
	@ManyToOne
	@JoinColumn(name = "SeatTypeId")
	SeatType seatType;
	
	@OneToMany(mappedBy = "seatLocation")
	List<CinemaRoom> listCinemaRoom;
	
	@OneToMany(mappedBy = "seatLocation")
	List<InvoiceDetail> listInvoiceDetail;
}
