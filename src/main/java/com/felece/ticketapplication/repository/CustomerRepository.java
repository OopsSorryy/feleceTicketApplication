package com.felece.ticketapplication.repository;


import com.felece.ticketapplication.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
