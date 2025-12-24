package com.product.productService.service;

import com.product.productService.entity.ProductEntity;
import com.product.productService.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public ProductEntity createProduct(ProductEntity product){
       return productRepo.save(product);
    }

    public List<ProductEntity> getAllProducts(){
        return productRepo.findAll();
    }

    public Optional<ProductEntity> getProductById(Long productId){
        return productRepo.findById(productId);
    }

    public void deleteProductById(Long productId){
         productRepo.deleteById(productId);
    }

    public ProductEntity updateProduct(Long id,ProductEntity newProduct){
        ProductEntity dbProduct = productRepo.findById(id).orElseThrow(()->new RuntimeException("Product Not Found with id "+id));
        dbProduct.setName(newProduct.getName());
        dbProduct.setPrice(newProduct.getPrice());

        productRepo.save(dbProduct);

        return dbProduct;

    }

}
