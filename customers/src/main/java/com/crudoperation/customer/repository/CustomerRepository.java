package com.crudoperation.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudoperation.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	// Check email or mobile number exist or not
	public Boolean existsByEmail(String email);

	public Boolean existsByMobileNumber(String mobileNumber);

}