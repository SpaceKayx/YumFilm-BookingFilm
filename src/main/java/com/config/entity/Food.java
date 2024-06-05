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
@Builder
@Table(name = "Food" )

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="FoodId")
	int foodId;
	
	@Column(name = "FoodName" , columnDefinition = "nvarchar(255)", nullable = false )
	String foodName;
	
	@Column(name = "Price" , nullable = false)
	double price;
	
	@Column(name = "Quantity" , nullable = false)
	int quantity;
	
	@Column(name = "Description" , columnDefinition= "nvarchar(max)" )
	String description;
	
	@Column(name = "FoodImage" , columnDefinition= "nvarchar(255)" )
	String foodImage;
	
	@Column(name = "Status", nullable = false)
	boolean status;
	

	@OneToMany(mappedBy = "food")
	List<OrderFood> listOrderFood;
}
