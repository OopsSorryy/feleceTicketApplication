package com.felece.ticketapplication.service;


import com.felece.ticketapplication.core.constant.Constant;
import com.felece.ticketapplication.core.exception.CustomerEmailAlreadyExistException;
import com.felece.ticketapplication.core.exception.CustomerNotFoundException;
import com.felece.ticketapplication.model.Customer;
import com.felece.ticketapplication.model.Role;
import com.felece.ticketapplication.model.SecurityCustomer;
import com.felece.ticketapplication.model.converter.CustomerConverter;
import com.felece.ticketapplication.model.request.CreateCustomerRequest;
import com.felece.ticketapplication.model.request.UpdateCustomerRequest;
import com.felece.ticketapplication.model.response.CustomerResponse;
import com.felece.ticketapplication.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    private final CustomerConverter customerConverter;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    protected Customer getCustomerByCustomerId(int customerId){
        return customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(Constant.CUSTOMER_NOT_FOUND));
    }

    public CustomerResponse createUserCustomer(CreateCustomerRequest request){

        Optional<Customer> customer = customerRepository.findCustomerByEmail(request.getEmail());
        if (customer.isPresent()) {
            throw new CustomerEmailAlreadyExistException(Constant.CUSTOMER_EMAIL_ALREADY_EXIST);
        }
        Customer customer1 = new Customer
                (request.getEmail(),
                        bCryptPasswordEncoder.encode(request.getPassword()),
                        bCryptPasswordEncoder.encode(request.getMatchingPassword()),
                        request.getFirstName(),
                        request.getLastName(),
                        Role.USER);
        Customer save = customerRepository.save(customer1);
        return customerConverter.convert(save);
    }

    public CustomerResponse createAdminCustomer(CreateCustomerRequest request){

        Optional<Customer> customer = customerRepository.findCustomerByEmail(request.getEmail());
        if (customer.isPresent()) {
            throw new CustomerEmailAlreadyExistException(Constant.CUSTOMER_EMAIL_ALREADY_EXIST);
        }
        Customer customer1 = new Customer
                (request.getEmail(),
                        bCryptPasswordEncoder.encode(request.getPassword()),
                        bCryptPasswordEncoder.encode(request.getMatchingPassword()),
                        request.getFirstName(),
                        request.getLastName(),
                        Role.ADMIN);
        Customer save = customerRepository.save(customer1);
        return customerConverter.convert(save);
    }


    public void deleteCustomerByCustomerId(int customerId){
        customerRepository.deleteById(getCustomerByCustomerId(customerId).getCustomerId());
    }

    public CustomerResponse updateCustomer(UpdateCustomerRequest request){
        Customer customer1 = getCustomerByCustomerId(request.getCustomerId());
        customer1.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        customer1.setMatchingPassword(bCryptPasswordEncoder.encode(request.getMatchingPassword()));
        customer1.setFirstName(request.getFirstName());
        customer1.setLastName(request.getLastName());
        return customerConverter.convert(customerRepository.save(customer1));
    }

    protected Customer findCustomerByEmail(String email){
        return customerRepository.findCustomerByEmail(email).orElseThrow(()->
                new CustomerNotFoundException(Constant.CUSTOMER_NOT_FOUND));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = findCustomerByEmail(username);
        return new SecurityCustomer(customer);
    }
}
