package com.crudoperation.customers.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_details")
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

	public Customer() {
	}

	public Long getId() {
		return id;
	}

	// Getter and Setter method for all variables
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.isBlank() || firstName.isEmpty()) {
			throw new RuntimeException("First name cannot be null or empty string.");
		} else {
			this.firstName = firstName;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.isBlank() || lastName.isEmpty()) {
			throw new RuntimeException("Last name cannot be null or empty string.");
		} else {
			this.lastName = lastName;
		}
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		if (mobileNumber != null) {
			this.mobileNumber = mobileNumber;
		} else {
			throw new RuntimeException("Mobile number cannot be null or empty numbers.");
		}
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		if (age != null) {
			this.age = age;
		} else {
			throw new RuntimeException("Age cannot be null or empty numbers.");
		}
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.isBlank() || email.isEmpty()) {
			throw new RuntimeException("Email address cannot be null or empty.");
		} else {
			this.email = email;
		}
	}

}