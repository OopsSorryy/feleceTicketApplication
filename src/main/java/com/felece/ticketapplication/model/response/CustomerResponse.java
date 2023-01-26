package com.felece.ticketapplication.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

    private int customerId;

    private String email;

    private String firstName;

    private String lastName;



}
