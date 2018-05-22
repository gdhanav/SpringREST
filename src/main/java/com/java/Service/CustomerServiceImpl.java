/**
 * 
 */
package com.java.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.dto.Customer;
import com.java.exception.CustomerException;

/**
 * @author Dhana Implementation for customer CRUD.
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
	 * 
	 * @param: customer
	 */
	@Override
	public void addCustomer(Customer customer) throws CustomerException {
		try {
			customers.add(customer);
		} catch (Exception e) {
			throw new CustomerException("Cannot Create Customer. Please reach out to support Team");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.java.Service.CustomerService#getCustomer(int) Get/Read customer
	 * by Id.
	 * 
	 * @param:Id
	 */
	@Override
	public Customer getCustomerById(int id) throws CustomerException {
		try {

			for (Customer customer : customers) {
				if (customer.getId() == id) {
					return customer;
				}
			}
		} catch (Exception e) {
			throw new CustomerException("Unable to get customer by ID. Please reach out to support Team");
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.java.Service.CustomerService#updateCustomer(com.java.dto.Customer)
	 * Update customer detail.
	 * 
	 * @param:customer
	 */
	@Override
	public void updateCustomer(Customer customer) throws CustomerException {

		try {
			Iterator<Customer> cust_iterator = customers.iterator();

			while (cust_iterator.hasNext()) {
				Customer cust = cust_iterator.next();
				if (cust.getId() == customer.getId()) {
					customers.remove(customers.indexOf(cust));
					customers.add(customer);
					System.out.println("Customer updated: " + customer.getId());
				}
			}
		} catch (Exception e) {
			throw new CustomerException("Cannot update Customer. Please reach out to support Team");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.java.Service.CustomerService#deletCustomer(int) Delete Customer
	 * by Id
	 * 
	 * @param:id
	 * 
	 */
	@Override
	public void deletCustomer(int id) throws CustomerException {

		Customer customer = null;
		try {
			for (Customer cust : customers) {
				if (cust.getId() == id) {
					customer = cust;
					System.out.println("Customer Deleted: " + id);
					break;
				}
			}

			customers.remove(customer);
		} catch (Exception e) {
			throw new CustomerException("Cannot delete Customer. Please reach out to support Team");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.java.Service.CustomerService#getAllCustomers() This method
	 * return all customers
	 */
	@Override
	public List<Customer> getAllCustomers() {
		return customers;
	}

}
