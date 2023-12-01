package com.example.websecondlab.util.validation;

import java.util.Set;

import jakarta.validation.ConstraintViolation;

public interface Validation {

    <T> boolean isValid(T object);

    <E> Set<ConstraintViolation<E>> violations(E object);
}