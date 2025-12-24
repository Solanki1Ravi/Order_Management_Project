package com.product.productService.controller;


import com.product.productService.entity.ProductEntity;
import com.product.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductEntity saveProduct(@RequestBody ProductEntity product){
        return productService.createProduct(product);
    }



    @GetMapping
    public List<ProductEntity> findAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Optional<ProductEntity> findProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable Long productId){
        productService.deleteProductById(productId);
    }


    @PutMapping("/{productId}")

    public ProductEntity updateProduct(@PathVariable Long productId,@RequestBody ProductEntity product){
       return productService.updateProduct(productId,product);
    }
}
