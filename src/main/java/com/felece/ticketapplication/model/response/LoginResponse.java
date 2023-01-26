package com.felece.ticketapplication.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {


    private String jwtToken;

    private CustomerResponse customerResponse;
}
