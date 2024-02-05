package com.customer.DAO;

import java.util.List;

import com.customer.Model.Customer;

public interface CustomerDAO {
	
	void addCustomer(Customer customer);
	List<Customer> getCustomerByFirst_name(String first_name);
	List<Customer> getCustomerByEmail(String email);
	List<Customer> getCustomerByCity(String city);
	List<Customer> getCustomerByPhone_number(long phone_number);
	Customer getCustomerById(String customerId);
	void updateCustomer(Customer user);
	void deleteCustomer(String customerId);
	List<Customer> getAllCustomer();

}
