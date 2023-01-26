package com.felece.ticketapplication.core.validator.create;


import com.felece.ticketapplication.model.request.CreateCustomerRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        CreateCustomerRequest customer = ( CreateCustomerRequest) obj;
        return customer.getPassword().equals(customer.getMatchingPassword());
    }


}