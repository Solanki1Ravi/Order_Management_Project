package com.product.productService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;

@Entity
@Table(name = "product_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
}
