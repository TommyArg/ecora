package com.tommy.microservices.cart_microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CartMicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartMicroservicesApplication.class, args);
    }

}
