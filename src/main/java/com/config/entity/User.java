package com.config.entity;

import java.io.Serializable;
import java.security.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.annotations.Nationalized;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the Users database table.
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int Userid;
	private LocalDateTime Birthdate;
	@Nationalized
	private String Email;
	@Nationalized
	private String Firstname;
	@Nationalized
	private String Lastname;
	 @Column(columnDefinition = "NCHAR(255)")
	private String password;
	@Nationalized
	private String Phonenumber;
	private boolean Role;
	private boolean Sex;
	private boolean Status;
	@Nationalized
	private String username;

}