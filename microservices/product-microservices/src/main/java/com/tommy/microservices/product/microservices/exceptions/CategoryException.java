package com.tommy.microservices.product.microservices.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryException extends RuntimeException {
    private final String message;
}
