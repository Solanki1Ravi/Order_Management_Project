package com.product.productService.repo;

import com.product.productService.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity,Long> {
}
