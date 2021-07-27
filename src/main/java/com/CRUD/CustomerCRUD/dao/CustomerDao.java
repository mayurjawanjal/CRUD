package com.CRUD.CustomerCRUD.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUD.CustomerCRUD.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

	List<Customer> findByLastName(String name);
	List<Customer> findByFirstName(String name);

}
