package com.felece.ticketapplication.model.converter;


import com.felece.ticketapplication.model.Customer;
import com.felece.ticketapplication.model.response.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public CustomerResponse convert(Customer from) {
        return new CustomerResponse
                (
                        from.getCustomerId(),
                        from.getEmail(),
                        from.getFirstName(),
                        from.getLastName()
                );
    }
}
