package com.crudoperation.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudoperation.customer.entity.Customer;
import com.crudoperation.customer.exceptionhandler.ExceptionHandler;
import com.crudoperation.customer.service.CustomerService;

/**
 * <b>CustomerController</b>
 * <h3>All methods</h3>
 * <ol>
 * <li>listAll : returns all the data from databse</li>
 * <li>saveOrUpdateCustomer : to save or update the data</li>
 * <li>getCustomerById : return selected customer data</li>
 * <li>existMobileNumber : check mobile number is exit or not</li>
 * <li>existEmail : check email is exit or not</li>
 * <li>deleteCustomer : delete selected customer data</li>
 * </ol>
 * 
 * @author Kartik
 */
@RestController
public class CustomerController {

	@Autowired
	CustomerService service;

	@GetMapping("/getAllCustomers")
	public List<Customer> listAll() {
		List<Customer> customers = service.listAll();
		return customers;
	}

	@PostMapping("/saveOrUpdateCustomer")
	public ResponseEntity<Object> saveOrUpdateCustomer(@RequestBody Customer customer) {
		try {
			Customer newCustomer = service.saveOrUpdateCustomer(customer);
			Boolean oldCustomer = newCustomer.equals(customer);
			if (oldCustomer) {
				return new ResponseEntity<Object>("{\"status\":\"success\"}", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("{\"status\":\"update\"}", HttpStatus.OK);
			}
		} catch (ExceptionHandler exception) {
			return ResponseEntity.badRequest().body(exception.getMessage());
		} catch (Exception exception) {
			return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping("/checkNumber")
	public ResponseEntity<Object> existMobileNumber(@RequestBody Customer customer) {
		try {
			Customer checkNumber = service.existMobileNumber(customer);
			Boolean oldNumber = checkNumber.equals(customer);
			if (oldNumber) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ExceptionHandler exception) {
			return ResponseEntity.badRequest().body(exception.getMessage());
		} catch (Exception exception) {
			return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/checkEmail")
	public ResponseEntity<Object> existEmail(@RequestBody Customer customer) {
		try {
			Customer checkEmail = service.existEmail(customer);
			Boolean oldEmail = checkEmail.equals(customer);
			if (oldEmail) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (ExceptionHandler exception) {
			return ResponseEntity.badRequest().body(exception.getMessage());
		} catch (Exception exception) {
			return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable Long id) {
		try {
			Customer checkCustomer = service.findById(id);
			if (checkCustomer != null) {
				service.delete(id);
				return new ResponseEntity<>("{\"status\":\"success\"}", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception exception) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}