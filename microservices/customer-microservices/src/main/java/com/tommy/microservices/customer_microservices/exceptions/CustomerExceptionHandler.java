package com.tommy.microservices.customer_microservices.exceptions;

import com.tommy.microservices.common_exceptions.GlobalExceptionHandler;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.tommy.microservices.customer_microservices")
@Primary

public class CustomerExceptionHandler extends GlobalExceptionHandler {

}

