package com.java.Service;

import java.util.List;

import com.java.dto.Customer;
import com.java.exception.CustomerException;

public interface CustomerService {

	public void addCustomer(Customer customer) throws CustomerException;

	public Customer getCustomerById(int id) throws CustomerException;

	public List<Customer> getAllCustomers() throws CustomerException;

	public void updateCustomer(Customer customer) throws CustomerException;

	public void deletCustomer(int id) throws CustomerException;

}
