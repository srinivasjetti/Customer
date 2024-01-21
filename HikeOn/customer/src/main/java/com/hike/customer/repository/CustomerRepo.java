package com.hike.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hike.customer.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
