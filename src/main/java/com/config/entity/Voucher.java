package com.config.entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Voucher")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Voucher {
	@Id
	@Column(name = "VoucherId")
	long voucherId;
	
	@Column(name = "VoucherName", columnDefinition  = "nvarchar(255)", nullable = false)
	String voucherName; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "StartDate" , columnDefinition = "datetime", nullable = false)
	Timestamp startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EndDate" ,columnDefinition = "datetime" , nullable = false)
	Timestamp endDate;
	
	@Column(name = "VoucherValue" , nullable = false)
	int voucherValue;
	
	@Column(name = "Status" , nullable = false)
	boolean status;
	
	@OneToMany(mappedBy = "voucher")
	List<Invoice> listInvoice;
}
