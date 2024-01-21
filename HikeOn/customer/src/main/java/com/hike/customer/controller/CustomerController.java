package com.hike.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hike.customer.entity.Customer;
import com.hike.customer.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping(value = "/saveCustomerDetails")
	public Customer saveCustomerDetails(@RequestBody Customer cus) {
		return service.saveCustomer(cus);
	}

}
