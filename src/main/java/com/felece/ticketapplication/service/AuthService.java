package com.felece.ticketapplication.service;

import com.felece.ticketapplication.core.security.JwtUtil;
import com.felece.ticketapplication.model.Customer;
import com.felece.ticketapplication.model.converter.CustomerConverter;
import com.felece.ticketapplication.model.converter.LoginResponseConverter;
import com.felece.ticketapplication.model.request.LoginRequest;
import com.felece.ticketapplication.model.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomerConverter customerConverter;
    private final CustomerService customerService;

    private final LoginResponseConverter converter;


    public LoginResponse login(LoginRequest request){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken
                (request.getEmail(),
                        request.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);
        Customer findCustomerByEmail = customerService.findCustomerByEmail(request.getEmail());
        return converter.convert(jwtUtil.generateToken(authenticate),customerConverter.convert(findCustomerByEmail));
    }
}
