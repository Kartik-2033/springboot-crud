package com.crudoperation.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>Customer</b> : Entity class
 * 
 * @author Kartik
 */
@Entity
@Table
@Getter
@Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String mobileNumber;
	private String presentAddress;
	private String permanentAddress;
	private int age;
	private int gender;
	private String email;

}