package com.example.productcompositeservice.clients;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.productcompositeservice.dto.CreateProductRequest;
import com.example.productcompositeservice.models.Product;

@Component
public class ProductClientFallback implements ProductClient {

    private static final Logger logger = LoggerFactory.getLogger(ProductClientFallback.class);

    @Override
    public Product getProductById(int id) {
        logger.error("Fallback triggered: getProductById({})", id);
        return new Product();
    }

}
