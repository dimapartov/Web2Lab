package com.example.websecondlab.util.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ValidationImpl implements Validation {

    private final Validator validator;


    @Autowired
    public ValidationImpl(Validator validator) {
        this.validator = validator;
    }


    @Override
    public <T> boolean isValid(T object) {
        return this.validator.validate(object).size() == 0;
    }

    @Override
    public <E> Set<ConstraintViolation<E>> violations(E object) {
        return this.validator.validate(object);
    }
}