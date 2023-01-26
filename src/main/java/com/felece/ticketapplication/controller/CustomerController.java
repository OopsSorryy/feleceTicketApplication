package com.felece.ticketapplication.controller;


import com.felece.ticketapplication.model.request.CreateCustomerRequest;
import com.felece.ticketapplication.model.request.UpdateCustomerRequest;
import com.felece.ticketapplication.model.response.CustomerResponse;
import com.felece.ticketapplication.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/user")
    public ResponseEntity<CustomerResponse> createUserCustomer(@RequestBody @Valid CreateCustomerRequest createCustomerRequest){
        return new ResponseEntity<>(customerService.createUserCustomer(createCustomerRequest), HttpStatus.CREATED);
    }
    @PostMapping("/admin")
    public ResponseEntity<CustomerResponse> createAdminCustomer(@RequestBody @Valid CreateCustomerRequest createCustomerRequest){
        return new ResponseEntity<>(customerService.createAdminCustomer(createCustomerRequest), HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteCustomerByCustomerId(@RequestParam("customerId") int customerId){
        customerService.deleteCustomerByCustomerId(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody @Valid UpdateCustomerRequest updateCustomerRequest){
        return new ResponseEntity<>(customerService.updateCustomer(updateCustomerRequest), HttpStatus.CREATED);
    }

}
