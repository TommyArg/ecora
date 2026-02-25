package com.tommy.microservices.product.microservices.category;


import com.tommy.microservices.product.microservices.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="categorias")
public class Category {

    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String descripcion;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> productos;



}
