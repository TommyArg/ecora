package com.tommy.microservices.product.microservices.exceptions;


import com.tommy.microservices.common_exceptions.ErrorResponse;
import com.tommy.microservices.common_exceptions.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice(basePackages = "com.tommy.microservices.product_microservices")
@Primary
@Slf4j
public class ProductExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(CategoryException.class)
    public ResponseEntity<ErrorResponse> handle (CategoryException exception)
    {
        var errors = new HashMap<String, String>();
        var fieldName= "product-service";
        errors.put(fieldName, exception.getMessage());

        log.warn("Category error: {}", exception.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorResponse> handle (ProductException exception)
    {

        var errors = new HashMap<String, String>();
        var fieldName = "product-service";
        errors.put(fieldName, exception.getMessage());

        log.warn("Error producto: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));

    }
}
