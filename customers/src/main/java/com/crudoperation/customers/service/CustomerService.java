package com.crudoperation.customers.service;

import java.util.List;

import com.crudoperation.customers.entity.Customer;

public interface CustomerService {

	Customer saveOrUpdateCustomer(Customer customer) throws Exception;

	List<Customer> listAll();

	Customer findById(Long id);

	void delete(Long id);

	Customer existMobileNumber(Customer customer) throws Exception;

	Customer existEmail(Customer customer) throws Exception;

}