package com.example.productcompositeservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.productcompositeservice.dto.CreateProductRequest;
import com.example.productcompositeservice.models.Product;

@FeignClient(name = "product-service", fallback = ProductClientFallback.class)
public interface ProductClient {


    // get all products
    @GetMapping("/products")
    List<Product> getAllProducts();

    // get product by id
    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable int id);

    // create product
    @PostMapping("/products")
    void createProduct(CreateProductRequest product);

}
