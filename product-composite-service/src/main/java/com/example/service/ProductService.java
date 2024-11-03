package com.example.productcompositeservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productcompositeservice.clients.ProductClient;
import com.example.productcompositeservice.dto.CreateProductRequest;
import com.example.productcompositeservice.models.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private final ProductClient productClient;
    public static int counter = 0;


    // get product by id
    public Product getProductById(int id) {
        return productClient.getProductById(id);
    }


}
