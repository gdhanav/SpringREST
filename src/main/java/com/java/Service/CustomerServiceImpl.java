/**
 * 
 */
package com.java.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.dto.Customer;

/**
 * @author Dhana
 * Implementation for customer CRUD.
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private List<Customer> customers = new ArrayList<Customer>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.java.Service.CustomerService#addCustomer(com.java.dto.Customer)
	 * Create or insert customer.
	 * @param: customer
	 */
	@Override
	public void addCustomer(Customer customer) {
		customers.add(customer);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.java.Service.CustomerService#getCustomer(int)
	 * Get/Read customer by Id.
	 * @param:Id
	 */
	@Override
	public Customer getCustomerById(int id) {

		for (Customer customer : customers) {
			if (customer.getId() == id) {
				return customer;
			}
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.java.Service.CustomerService#updateCustomer(com.java.dto.Customer)
	 * Update customer detail.
	 * @param:customer
	 */
	@Override
	public void updateCustomer(Customer customer) {

		Iterator<Customer> cust_iterator = customers.iterator();

		while (cust_iterator.hasNext()) {
			Customer cust = cust_iterator.next();
			if (cust.getId() == customer.getId()) {
				customers.remove(customers.indexOf(cust));
				customers.add(customer);
				System.out.println("Customer updated: " + customer.getId());
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.java.Service.CustomerService#deletCustomer(int)
	 * Delete Customer by Id
	 * @param:id
	 * 
	 */
	@Override
	public void deletCustomer(int id) {

		Customer customer =null;
		for (Customer cust : customers) {
			if (cust.getId() == id) {
				customer =cust;
				System.out.println("Customer Deleted: " + id);
				break;
			}
		}

		customers.remove(customer);

	}

	/* (non-Javadoc)
	 * @see com.java.Service.CustomerService#getAllCustomers()
	 * This method return all customers
	 */
	@Override
	public List<Customer> getAllCustomers() {

		return customers;
	}

}
