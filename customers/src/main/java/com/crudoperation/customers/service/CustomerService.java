package com.crudoperation.customers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crudoperation.customers.entity.Customer;
import com.crudoperation.customers.exceptionhandle.ExceptionHandler;
import com.crudoperation.customers.repository.CustomerRepository;

/**
 * <b>CustomerService</b>
 * <h3>All methods</h3>
 * <ol>
 * <li>listAll : fetch all data from the repository</li>
 * <li>saveOrUpdateCustomer : to save or update the data</li>
 * <li>findById : to find customer data according to 'id'</li>
 * <li>delete : to delete customer data according to 'id'</li>
 * </ol>
 * 
 * @author Kartik
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public List<Customer> listAll() {
		return repository.findAll();
	}

	public Customer saveOrUpdateCustomer(Customer customer) throws Exception {
		Boolean checkEmail = repository.existsByEmail(customer.getEmail());
		Boolean checkMobileNumber = repository.existsByMobileNumber(customer.getMobileNumber());
		if (customer.getId() != null) {
			Optional<Customer> existCustomer = repository.findById(customer.getId());
			if (existCustomer.isPresent()) {
				Customer newCustomer = existCustomer.get();
				String email = null;
				String mobileNumber = null;
				if (checkMobileNumber) {
					if (customer.getMobileNumber().equalsIgnoreCase(newCustomer.getMobileNumber())) {
						mobileNumber = newCustomer.getMobileNumber();
					} else {
						throw new ExceptionHandler("mobileNumberException");
					}
				} else {
					mobileNumber = customer.getMobileNumber();
				}
				if (checkEmail) {
					if (customer.getEmail().equalsIgnoreCase(newCustomer.getEmail())) {
						email = newCustomer.getEmail();
					} else {
						throw new ExceptionHandler("emailException");
					}
				} else {
					email = customer.getEmail();
				}
				newCustomer.setFirstName(customer.getFirstName());
				newCustomer.setLastName(customer.getLastName());
				newCustomer.setDateOfBirth(customer.getDateOfBirth());
				newCustomer.setMobileNumber(mobileNumber);
				newCustomer.setPresentAddress(customer.getPresentAddress());
				newCustomer.setPermanentAddress(customer.getPermanentAddress());
				newCustomer.setAge(customer.getAge());
				newCustomer.setGender(customer.getGender());
				newCustomer.setEmail(email);
				newCustomer = repository.save(newCustomer);
				return newCustomer;
			}
		} else {
			if (checkMobileNumber) {
				throw new ExceptionHandler("mobileNumberException");
			} else if (checkEmail) {
				throw new ExceptionHandler("emailException");
			} else {
				return repository.save(customer);
			}
		}
		return customer;
	}

	public Customer findById(Long id) {
		return repository.findById(id).orElseThrow();
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Customer existMobileNumber(Customer customer) throws Exception {
		Boolean checkMobileNumber = repository.existsByMobileNumber(customer.getMobileNumber());
		if (customer.getId() != null) {
			Optional<Customer> existCustomer = repository.findById(customer.getId());
			if (existCustomer.isPresent()) {
				Customer newCustomer = existCustomer.get();
				String mobileNumber = null;
				if (checkMobileNumber) {
					if (customer.getMobileNumber().equalsIgnoreCase(newCustomer.getMobileNumber())) {
						mobileNumber = newCustomer.getMobileNumber();
					} else {
						throw new ExceptionHandler("mobileNumberException");
					}
				} else {
					mobileNumber = customer.getMobileNumber();
				}
				newCustomer.setMobileNumber(mobileNumber);
				return newCustomer;
			}
		} else {
			if (checkMobileNumber) {
				throw new ExceptionHandler("mobileNumberException");
			} else {
				return customer;
			}
		}
		return customer;
	}

	public Customer existEmail(Customer customer) throws Exception {
		Boolean checkEmail = repository.existsByEmail(customer.getEmail());
		if (customer.getId() != null) {
			Optional<Customer> existCustomer = repository.findById(customer.getId());
			if (existCustomer.isPresent()) {
				Customer newCustomer = existCustomer.get();
				String email = null;
				if (checkEmail) {
					if (customer.getEmail().equalsIgnoreCase(newCustomer.getEmail())) {
						email = newCustomer.getEmail();
					} else {
						throw new ExceptionHandler("emailException");
					}
				} else {
					email = customer.getEmail();
				}
				newCustomer.setEmail(email);
				return newCustomer;
			}
		} else {
			if (checkEmail) {
				throw new ExceptionHandler("emailException");
			} else {
				return customer;
			}
		}
		return customer;
	}

}