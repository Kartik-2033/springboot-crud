package com.crudoperation.customer.service;

import java.util.List;

import com.crudoperation.customer.entity.Customer;

/**
 * <b>CustomerService</b>
 * <h3>All methods</h3>
 * <ol>
 * <li>saveOrUpdateCustomer : to save or update the data</li>
 * <li>listAll : returns all the data from databse</li>
 * <li>findById : find customer data by id</li>
 * <li>delete : delete customer data</li>
 * <li>existMobileNumber : check mobile number is exit or not</li>
 * <li>existEmail : check email is exit or not</li>
 * </ol>
 * 
 * @author Kartik
 */
public interface CustomerService {

	public Customer saveOrUpdateCustomer(Customer customer) throws Exception;

	public List<Customer> listAll();

	public Customer findById(Long id);

	public void delete(Long id);

	public Customer existMobileNumber(Customer customer) throws Exception;

	public Customer existEmail(Customer customer) throws Exception;

}