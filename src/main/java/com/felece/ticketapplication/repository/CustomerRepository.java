package com.felece.ticketapplication.repository;


import com.felece.ticketapplication.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findCustomerByEmail(String email);
}
