package com.example.websecondlab.util.validation;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface Validation {

    <T> boolean isValid(T object);

    <E> Set<ConstraintViolation<E>> violations(E object);
}