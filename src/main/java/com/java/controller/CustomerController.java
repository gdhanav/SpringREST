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

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping(value="/create")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
		try{
			service.addCustomer(customer);
		}catch(Exception e){
			return new ResponseEntity<String>("Cannot Create Customer. Please reach out to support Team", HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<String>("Customer detail created.",HttpStatus.OK);
	}
	@GetMapping(value="/getCustomers")
	public ResponseEntity<List<Customer>> getCustomers(){
		try{
			return new ResponseEntity<List<Customer>>(service.getAllCustomers(),HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping(value="/getCustomerById/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id){
		try{
			return new ResponseEntity<Customer>(service.getCustomerById(id),HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping(value="/updateCustomer")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
		try{
			service.updateCustomer(customer);
		}catch(Exception e){
			return new ResponseEntity<String>("Cannot update Customer. Please reach out to support Team", HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<String>("Customer detail updated.",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id){
		try{
			service.deletCustomer(id);
		}catch(Exception e){
			return new ResponseEntity<String>("Cannot delete Customer. Please reach out to support Team", HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<String>("Customer detail deleted.",HttpStatus.OK);
	}

}
