package com.config.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "InvoiceDetail" )
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceDetail {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "InvoiceDetailId")
	long invoiceDetailId;
	
	@Column(name = "Price")
	double price;
	
	@Column(name = "Note")
	String note;
	
	@ManyToOne
	@JoinColumn(name = "InvoiceId")
	Invoice invoice;
	
	@ManyToOne
	@JoinColumn(name = "SeatLocationId")
	SeatLocation seatLocation;
	
	@ManyToOne
	@JoinColumn(name = "ShowTimeId")
	ShowTime showTime;
	
	
	
	
}
