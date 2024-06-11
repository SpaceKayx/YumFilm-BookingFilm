package com.config.entity;


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
@Table(name = "OrderFood" )
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderFood {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderFoodId")
	long orderFoodId;
	@Column(name = "Price" , nullable = false)
	double price;
	@Column(name = "Quantity" , nullable = false)
	int quantity;
	
	@ManyToOne
	@JoinColumn(name = "FoodId")
	Food food;
	
	@ManyToOne
	@JoinColumn(name = "InvoiceId")
	@JsonIgnore
	Invoice invoice;
}
