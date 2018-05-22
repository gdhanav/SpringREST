package com.java.Service;

import java.util.List;

import com.java.dto.Customer;

public interface CustomerService {
	
	public void addCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public List<Customer> getAllCustomers();
	public void updateCustomer(Customer customer);
	public void deletCustomer(int id);

}
