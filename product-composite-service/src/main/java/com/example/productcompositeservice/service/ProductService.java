package com.example.productcompositeservice.service;

import com.example.productcompositeservice.clients.ProductClient;
import com.example.productcompositeservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class ProductService {


    private final ProductClient productClient;

    @Autowired
    public ProductService(@Qualifier("com.example.productcompositeservice.clients.ProductClient") ProductClient productClient) {
        this.productClient = productClient;
    }
    // get product by id
    public Product getProductById(int id) {
        return productClient.getProductById(id);
    }
}