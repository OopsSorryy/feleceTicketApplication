package com.felece.ticketapplication.model.request;


import com.felece.ticketapplication.core.validator.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

    @NotNull
    private int customerId;

    @NotBlank
    @Email(regexp = ".+@.+\\..+")
    private String email;

    @ValidPassword
    @NotBlank
    private String password;

    @NotBlank
    private String matchingPassword;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

}
