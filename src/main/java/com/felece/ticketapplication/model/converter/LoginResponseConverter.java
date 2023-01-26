package com.felece.ticketapplication.model.converter;

import com.felece.ticketapplication.model.response.CustomerResponse;
import com.felece.ticketapplication.model.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LoginResponseConverter {

    public LoginResponse convert(String token, CustomerResponse customer){
        return new LoginResponse(token,customer);

    }
}
