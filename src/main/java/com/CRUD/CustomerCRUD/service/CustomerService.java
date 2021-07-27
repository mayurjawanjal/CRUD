package com.CRUD.CustomerCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.CRUD.CustomerCRUD.dao.CustomerDao;
import com.CRUD.CustomerCRUD.model.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao dao;
	
	public List<Customer> addCustomers(List<Customer> customer){
		return (List<Customer>) dao.saveAll(customer);
	}
	
	public String addCustomer(Customer customer) {
		dao.save(customer);
		return "Registration Successfull!!";
	}

	public List<Customer> getAllCustomerDetails(){
		return (List<Customer>)dao.findAll();
	}

	public Customer getCustomerById(int id) {
		return dao.findById(id).orElse(null);
	}
	
	public List<Customer> getCustomerByName(String name){
		List<Customer> namelist= (List<Customer>)dao.findByFirstName(name);
		namelist.addAll((List<Customer>)dao.findByLastName(name));
		return namelist;
	}
	
	/*
	 * public List<Customer> getCustomerByLastName(String name){ return
	 * (List<Customer>)dao.findByLastName(name); }
	 */
	public List<Customer> deleteCustomer(int id) {
		dao.deleteById(id);
		return (List<Customer>)dao.findAll();
	}
	
	public String updateCustomer(Customer customer) {
		Customer existingCustomer=  dao.findById(customer.getId()).orElse(null);
		if(!(existingCustomer == null)) {
			existingCustomer.setFirstName(customer.getFirstName());
			existingCustomer.setLastName(customer.getLastName());
			existingCustomer.setEmailId(customer.getEmailId());
			existingCustomer.setNumber(customer.getNumber());
			return "Entry Updated"; 
		}
			return "No Such Customer to be updated!!Click add customer to add new Customer";
		
	}
}
