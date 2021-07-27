package com.CRUD.CustomerCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.CRUD.CustomerCRUD.model.Customer;
import com.CRUD.CustomerCRUD.service.CustomerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService service;

	/*
	 * @Autowired private
	 * 
	 */	@PostMapping("/addCustomers")
	public List<Customer> addCustomers(@RequestBody List<Customer> customer){
		return service.addCustomers(customer);
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}
	
	@GetMapping("/getAllCustomerDetails")
	public List<Customer> getAllCustomerDetails(){
		return service.getAllCustomerDetails();
	}
	
	@GetMapping("/getCustomerById/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return service.getCustomerById(id);
	}
	
	@GetMapping("/getCustomerByName/{name}")
	public List<Customer> getCustomerByName(@PathVariable String name){
		return service.getCustomerByName(name);
	}
	
	/*
	 * @GetMapping("/getCustomerByLastName/{name}") public List<Customer>
	 * getCustomerByLastName(@PathVariable String name){ return
	 * service.getCustomerByLastName(name); }
	 */
	
	@DeleteMapping("/deleteCustomer/{id}")
	public List<Customer>deleteCustomer(@PathVariable int id) {
		return service.deleteCustomer(id);
	}
	
	@PutMapping("/update")
	public String updateCustomer(@RequestBody Customer customer){
		return service.updateCustomer(customer);
	}
	
}