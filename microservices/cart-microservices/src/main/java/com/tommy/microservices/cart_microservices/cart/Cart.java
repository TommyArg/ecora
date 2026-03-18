package com.tommy.microservices.cart_microservices.cart;

import com.tommy.microservices.cart_microservices.cartItem.CartItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Cart {
    @Id
    private String Id;
    private String customerId;
    private List<CartItem> items;

}
