package com.rashid.ashrafii.SpringRestAPI.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidater implements ConstraintValidator<EmployeeRoleValidation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       List<String> roles = List.of("USER","ADMIN");
       return roles.contains(value);
    }


}
