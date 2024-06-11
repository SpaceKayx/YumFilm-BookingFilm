package com.config.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;

//import org.hibernate.metamodel.ValueClassification;

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
@Table(name = "Invoice" )
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Invoice  implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "InvoiceId")
	long invoiceId;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "CreateDate", columnDefinition = "datetime", nullable = false)
	@Builder.Default
	Date creatDate = new Date();
	
	@Column(name = "PaymentStatus", nullable = false)
	@Builder.Default
	boolean paymentStatus = false;
	
	@Column(name = "Note" ,columnDefinition = "nvarchar(255)")
	String note;
	
	@Column(name = "Total", nullable = false)
	double total;
	
	@Column(name = "Status", nullable = false)
	@Builder.Default
	boolean status = true;
	
	@ManyToOne
	@JoinColumn(name = "VoucherId")
	Voucher voucher;
	
	@ManyToOne
	@JoinColumn(name = "UserId")
	User user;
	
	@ManyToOne
	@JoinColumn(name = "PaymentId")
	Payment payment;
	
	@OneToMany(mappedBy="invoice", cascade = CascadeType.ALL)
	@JsonIgnore
	List<OrderFood> listOrderFood;
	
	@OneToMany(mappedBy="invoice", cascade = CascadeType.ALL)
	@JsonIgnore
	List<InvoiceDetail> listInvoiceDetail;
}
