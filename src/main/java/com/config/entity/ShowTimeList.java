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
@Table(name = "ShowTimeList" )
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShowTimeList {
	@Id
	@Column(name = "ShowTimeListId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int showTimeListId;
	@Column(name = "ShowTimeFrame" , columnDefinition = "nvarchar(100)", nullable = false)
	String showTimeFrame; 
	
	@Column(name = "Status" , nullable = false)
	boolean status;
	
	@OneToMany(mappedBy ="showTimeList")
	List<ShowTime> showTime;
}
