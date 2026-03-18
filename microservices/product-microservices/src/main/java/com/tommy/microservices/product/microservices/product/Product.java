package com.tommy.microservices.product.microservices.product;

import com.tommy.microservices.product.microservices.category.Category;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String urlimagen;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Category categoria;

    @PrePersist
    public void prePersist() {
        if (stock == null) {
            stock = 0;
        }
    }
}
