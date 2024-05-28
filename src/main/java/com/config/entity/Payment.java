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
@Table(name = "Payment" )
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PaymentId")
	int paymentId;
	
	@Column(name = "PaymentName" , columnDefinition = "nvarchar(255)", nullable = false)
	String paymentName;
	
	@Column(name = "Status", nullable = false)
	boolean status;
	
	@OneToMany(mappedBy = "payment")
	List<Invoice> listInvoice;
}
