package com.crudoperation.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudoperation.customers.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	// Check email or mobile number exist or not
	Boolean existsByEmail(String email);
	Boolean existsByMobileNumber(String mobileNumber);

}