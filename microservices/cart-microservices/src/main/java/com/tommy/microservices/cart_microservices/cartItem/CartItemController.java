package com.tommy.microservices.cart_microservices.cartItem;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/{customerId}/cart/item")
@RequiredArgsConstructor

public class CartItemController {
    private final CartItemService cartItemService;

    @PostMapping()
    public ResponseEntity<String> addItemToCart(@PathVariable("customerId") String customerId, @Valid @RequestBody CartItemRequest cartItemRequest) {
        return ResponseEntity.ok(cartItemService.addItemToCart(customerId, cartItemRequest));

    }


}

