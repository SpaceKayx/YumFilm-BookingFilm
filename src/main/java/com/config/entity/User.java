package com.config.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
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
@Table(name = "Users" , uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
	@Id
	@Column(name = "UserId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long userId;
	
	@Column(name = "LastName" , columnDefinition = "nvarchar(50)", nullable = false)
	String lastName; 
	
	@Column(name = "FirstName" , columnDefinition ="nvarchar(50)", nullable = false)
	String firstName;
	
	@Column(name = "PhoneNumber", columnDefinition = "nvarchar(50)", nullable = false)
	String phoneNumber;
	
	@Column(name = "Email" , columnDefinition = "nvarchar(255)" , nullable = false)
	String email;
	
	@Column(name = "Username" , columnDefinition= "varchar(255)" , nullable = false)
	String username;
	
	@Column(name = "Password" , columnDefinition = "nchar(60)", nullable = false)
	String password;
	
	@Column(name = "Birthdate" , nullable =false)
	@Temporal(TemporalType.DATE)
	Date birthday;
	
	@Column(name = "Sex", nullable = false)
	boolean sex;
	
	@Column(name = "Role" , nullable = false)
	boolean role;
	
	@Column(name = "Status", nullable = false)
	boolean status;
	
	@OneToMany(mappedBy = "user")
	List<Invoice> listInvoice;
}
