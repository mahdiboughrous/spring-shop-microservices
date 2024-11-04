package com.example.productservice.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public Product updateProduct(int id, Product productDetails) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDetails.getName());
            product.setWeight(productDetails.getWeight());
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    public boolean deleteProduct(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
