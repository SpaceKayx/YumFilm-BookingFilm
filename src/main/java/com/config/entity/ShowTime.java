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
@Table(name = "ShowTime" )
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShowTime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ShowTimeId")
	int showTimeId;
	@Temporal(value = TemporalType.DATE)
	@Column(name = "ShowTimeDate", columnDefinition = "date", nullable = false)
	Date showTimeDate;
	@Column(name = "Status" , nullable = false)
	boolean status;
	@Column(name = "Price" , nullable = false)
	double price ; 
	
	@ManyToOne
	@JoinColumn(name = "ShowTimeListId")
	ShowTimeList showTimeList;
	
	@ManyToOne
	@JoinColumn(name = "FilmId")
	Film film;
	
	@OneToMany(mappedBy = "showTime")
	List<ShowTimeSeatType> listShowTimeSeatType;
	
	@OneToMany(mappedBy = "showTime")
	List<CinemaRoom> listCinemaRoom;
	
	@OneToMany(mappedBy = "showTime")
	List<InvoiceDetail> listInvoiceDetail;
}
