package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.Service.CustomerService;
import com.java.dto.Customer;
import com.java.exception.CustomerException;

/**
 * @author Dhana
 * Customer controller to support manage customer profiles
 *
 */
@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping(value = "/create")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) throws CustomerException {
		service.addCustomer(customer);
		return new ResponseEntity<String>("Customer detail created.", HttpStatus.OK);
	}

	@GetMapping(value = "/getCustomers")
	public ResponseEntity<List<Customer>> getCustomers() throws CustomerException {
		return new ResponseEntity<List<Customer>>(service.getAllCustomers(), HttpStatus.OK);

	}

	@GetMapping(value = "/getCustomerById/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id) throws CustomerException {
		return new ResponseEntity<Customer>(service.getCustomerById(id), HttpStatus.OK);
	}

	@PutMapping(value = "/updateCustomer")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) throws CustomerException {
		service.updateCustomer(customer);
		return new ResponseEntity<String>("Customer detail updated.", HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id) throws CustomerException {
		service.deletCustomer(id);
		return new ResponseEntity<String>("Customer detail deleted.", HttpStatus.OK);
	}

}
