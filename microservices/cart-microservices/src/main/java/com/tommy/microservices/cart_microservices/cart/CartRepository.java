package com.tommy.microservices.cart_microservices.cart;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    java.util.Optional<Cart> findByCustomerId(String customerId);


}
