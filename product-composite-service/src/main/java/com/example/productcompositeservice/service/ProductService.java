package com.boughrous.productcompositeservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boughrous.productcompositeservice.clients.ProductClient;
import com.boughrous.productcompositeservice.dto.CreateProductRequest;
import com.boughrous.productcompositeservice.models.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private final ProductClient productClient;
    public static int counter = 0;

    // get all products
    @CircuitBreaker(name = "productService", fallbackMethod = "productServiceFallback")
    public List<Product> getAllProducts() {
        // count the number of times the getAllProducts method is called
        counter++;
        logger.atInfo().log("getAllProducts method called " + counter + " times");
        return productClient.getAllProducts();
    }

    // fallback method for getAllProducts
    public List<Product> productServiceFallback(Exception e) {

        logger.atInfo().log("Fallback method for getAllProducts called");
        // return empty list of products
        List<Product> products = List.of(new Product());
        return products;

    }

    // get product by id
    public Product getProductById(int id) {
        return productClient.getProductById(id);
    }

    // create product
    public void createProduct(CreateProductRequest product) {
        productClient.createProduct(product);
    }

}
