package com.tommy.microservices.cart_microservices.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CartException extends RuntimeException {
    private final String message;
}